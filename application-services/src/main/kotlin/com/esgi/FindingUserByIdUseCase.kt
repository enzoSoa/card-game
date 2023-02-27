package com.esgi

import com.esgi.persistence.UserPersistence

class FindingUserByIdUseCase(
    private val persistence: UserPersistence,
) {
    fun execute(id: String): User {
        val userDocument = persistence.findById(id).orElseThrow {
            Error("No user with this id has been found")
        }

        return User(
            userDocument.nickname,
            userDocument.coins,
            userDocument.deck,
        )
    }
}