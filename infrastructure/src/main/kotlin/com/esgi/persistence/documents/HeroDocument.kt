package com.esgi.persistence.documents

import com.esgi.Rarity
import com.esgi.Speciality
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class HeroDocument(
    @Id val id: String? = null,
    val name: String,
    val speciality: Speciality,
    val rarity: Rarity,
    var hp: Double,
    var power: Double,
    var armor: Double,
    var exp: Int = 0,
    var level: Int = 1
)