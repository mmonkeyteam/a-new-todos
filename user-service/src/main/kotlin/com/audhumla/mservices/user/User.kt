package com.audhumla.mservices.user

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val surname: String

) {
    constructor(name: String, surname: String) : this(0, name, surname)

    init {
        require(name.isNotEmpty()) { "Invalid name: it cannot be empty" }
        require(surname.isNotEmpty()) { "Invalid surname: it cannot be empty" }
    }
}
