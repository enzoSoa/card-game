package com.esgi

import com.esgi.persistence.UserPersistence


class FindingAllUsersUseCase(
    private val persistence: UserPersistence,
) {
    fun execute(): List<User> {
        return persistence.findAll().map { User(
            it.nickname,
            it.coins,
            it.deck,
        ) }
    }
}