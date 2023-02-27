package com.esgi

open class UserCreationService {
    open fun execute(name: String): User {
        return User(name, 4, listOf())
    }
}