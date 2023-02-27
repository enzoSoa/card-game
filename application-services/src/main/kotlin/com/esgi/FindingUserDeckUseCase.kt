package com.esgi

import com.esgi.persistence.UserPersistence

class FindingUserDeckUseCase(
    private val persistence: UserPersistence,
) {
    fun execute(userId: String): List<Hero> {
        val user = persistence.findById(userId).orElseThrow {
            Error("No user with this id has been found")
        }

        return user.deck
    }
}