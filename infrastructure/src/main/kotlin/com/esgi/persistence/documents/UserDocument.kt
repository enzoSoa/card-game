package com.esgi.persistence.documents

import com.esgi.Hero
import com.esgi.User
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class UserDocument(
    @Id val id: String? = null,
    val nickname: String,
    var coins: Int,
    var deck: List<Hero>
)