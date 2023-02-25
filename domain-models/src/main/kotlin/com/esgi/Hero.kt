package com.esgi

data class Hero(
    val name: String,
    val speciality: Speciality,
    val rarity: Rarity,
    var hp: Double,
    var power: Double,
    var armor: Double,
    var exp: Int = 0,
    var level: Int = 1
)
