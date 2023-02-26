package com.esgi

import com.esgi.interfaces.UserPersistence

class UserCreationUseCase(private val persistence: UserPersistence) {
    private val userCreationService = UserCreationService()
    fun execute(name: String) {
        val user = userCreationService.execute(name)
        persistence.insert(user)
    }
}