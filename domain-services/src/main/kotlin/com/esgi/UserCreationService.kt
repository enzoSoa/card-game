package com.esgi

class UserCreationService {
    fun execute(name: String): User {
        return User(name, 4, listOf<Hero>())
    }
}