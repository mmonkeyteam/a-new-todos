package com.audhumla.mservices.user

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
class UserRepositoryTest @Autowired constructor(
    private val entityManager: TestEntityManager,
    private val userRepository: UserRepository
) {

    @Test
    fun `find by name and surname when user exists`() {
        val userMarioRossi = User("Mario", "Rossi")
        val userJohnSnow = User("John", "Snow")
        entityManager.persistAndFlush(userMarioRossi)
        entityManager.persistAndFlush(userJohnSnow)

        val actual = userRepository.findByNameAndSurname("Mario", "Rossi")

        assertThat(actual.size).isEqualTo(1)
        assertThat(actual.first()).isEqualTo(userMarioRossi)
    }

    @Test
    fun `find by name and surname when no user exists`() {
        val actual = userRepository.findByNameAndSurname("Mario", "Rossi")

        assertThat(actual.size).isEqualTo(0)
    }

    @Test
    fun `find by name when multiple user with same name exists`() {
        val userMarioRossi = User("Mario", "Rossi")
        val userMarioSnow = User("Mario", "Snow")
        entityManager.persistAndFlush(userMarioRossi)
        entityManager.persistAndFlush(userMarioSnow)

        val actual = userRepository.findByName("Mario")

        assertThat(actual.size).isEqualTo(2)
        assertThat(actual).isEqualTo(listOf(userMarioRossi, userMarioSnow))
    }

    @Test
    fun `find by name when no users with name exists`() {
        val userMarioRossi = User("Mario", "Rossi")
        val userMarioSnow = User("Mario", "Snow")
        entityManager.persistAndFlush(userMarioRossi)
        entityManager.persistAndFlush(userMarioSnow)

        val actual = userRepository.findByName("Luke")

        assertThat(actual.size).isEqualTo(0)
    }

    @Test
    fun `find by surname when users with surname exists`() {
        val userMarioRossi = User("Mario", "Rossi")
        val userMarioSnow = User("Mario", "Snow")
        entityManager.persistAndFlush(userMarioRossi)
        entityManager.persistAndFlush(userMarioSnow)

        val actual = userRepository.findBySurname("Skywalker")

        assertThat(actual.size).isEqualTo(0)
    }

    @AfterEach
    fun after() {
        entityManager.clear()
    }
}
