package com.esgi

interface HeroPersistence{
    fun save(hero: Hero)
}

class HeroCreationUseCase(private val persistence: HeroPersistence) {
    private val heroCreationService = HeroCreationService()
    fun execute(name: String, speciality: Speciality, rarity: Rarity) {
        val hero = heroCreationService.execute(name, speciality, rarity)
        persistence.save(hero)
    }
}