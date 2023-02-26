package com.esgi.persistence.documents

import com.esgi.Hero
import com.esgi.User
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class UserDocument(
    @Id val id: String? = null,
    val nickname: String,
    val coins: Int,
    val deck: List<Hero>
) {
    constructor(user: User) : this(
        nickname = user.nickname,
        coins = user.coins,
        deck = user.deck,
    )
}