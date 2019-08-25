package com.audhumla.mservices.user

import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {

    fun findByNameAndSurname(name: String, surname: String): List<User>

    fun findByName(name: String): List<User>

    fun findBySurname(surname: String): List <User>
}
