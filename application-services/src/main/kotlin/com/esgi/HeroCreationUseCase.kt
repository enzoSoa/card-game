package com.esgi

interface HeroPersistence {
    fun insert(hero: Hero)
}

class HeroCreationUseCase(private val persistence: HeroPersistence) {
    private val heroCreationService = HeroCreationService()
    fun execute(name: String, speciality: Speciality, rarity: Rarity) {
        val hero = heroCreationService.execute(name, speciality, rarity)
        persistence.insert(hero)
    }
}