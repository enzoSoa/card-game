package com.esgi

import com.esgi.persistence.HeroPersistence


class FindingHeroByIdUseCase(
    private val persistence: HeroPersistence,
) {
    fun execute(id: String): Hero {
        val heroDocument = persistence.findById(id).orElseThrow {
            Error("No hero with this id has been found")
        }

        return Hero(
            heroDocument.name,
            heroDocument.speciality,
            heroDocument.rarity,
            heroDocument.hp,
            heroDocument.power,
            heroDocument.armor,
            heroDocument.exp,
            heroDocument.level
        )
    }
}