package com.esgi.persistence.adapters

import com.esgi.User
import com.esgi.persistence.UserPersistence
import com.esgi.persistence.documents.UserDocument
import com.esgi.persistence.repositories.UserRepository
import java.util.*

class UserPersistenceAdapter(
    private val userRepository: UserRepository
): UserPersistence {
    override fun insert(user: User) {
        val userDocument = UserDocument(
            nickname = user.nickname,
            coins = user.coins,
            deck = user.deck
        )

        userRepository.insert(userDocument)
    }

    override fun findAll(): MutableList<User> {
        return userRepository.findAll().map { userDocument ->
            User(
                userDocument.nickname,
                userDocument.coins,
                userDocument.deck,
            )
        }.toMutableList()
    }

    override fun findById(id: String): Optional<User> {
        return userRepository.findById(id).map { userDocument ->
            User(
                userDocument.nickname,
                userDocument.coins,
                userDocument.deck,
            )
        }
    }

    override fun save(user: User) {
        val userDocument = UserDocument(
            nickname = user.nickname,
            coins = user.coins,
            deck = user.deck
        )

        userRepository.save(userDocument)
    }
}