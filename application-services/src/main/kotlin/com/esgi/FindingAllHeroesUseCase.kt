package com.esgi

import com.esgi.persistence.HeroPersistence


class FindingAllHeroesUseCase(
    private val persistence: HeroPersistence,
) {
    fun execute(): List<Hero> {
        return persistence.findAll().map { Hero(
            it.name,
            it.speciality,
            it.rarity,
            it.hp,
            it.power,
            it.armor,
            it.exp,
            it.level
        ) }
    }
}