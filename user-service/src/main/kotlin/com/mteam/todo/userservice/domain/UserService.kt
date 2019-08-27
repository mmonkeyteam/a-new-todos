package com.mteam.todo.userservice.domain

import com.mteam.todo.userservice.api.CreateUserRequest
import com.mteam.todo.userservice.api.CreateUserResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Transactional
@Service
class UserService (
    @Autowired private val userRepository: UserRepository
){

    /**
     * Returns the User with the given [userId], if it exists.
     */
    fun findUserById(userId: Long): Optional<User> {
        return userRepository.findById(userId)
    }

    /**
     * Saves the User with the passed information in [createUserRequest]
     */
    fun createUser(createUserRequest: CreateUserRequest): CreateUserResponse? {
        var user = User(createUserRequest.name, createUserRequest.surname)
        var savedUser = userRepository.save(user)
        return CreateUserResponse(savedUser.id)
    }

}