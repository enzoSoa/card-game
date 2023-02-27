package com.esgi.persistence.adapters

import com.esgi.Hero
import com.esgi.persistence.HeroPersistence
import com.esgi.persistence.documents.HeroDocument
import com.esgi.persistence.repositories.HeroRepository
import java.util.*

class HeroPersistenceAdapter(
    private val heroRepository: HeroRepository
): HeroPersistence {
    override fun insert(hero: Hero) {
        heroRepository.insert(HeroDocument(
            name = hero.name,
            speciality = hero.speciality,
            rarity = hero.rarity,
            hp = hero.hp,
            power = hero.power,
            armor = hero.armor,
            exp = hero.exp,
            level = hero.level
        ))
    }

    override fun findAll(): List<Hero> {
        return heroRepository.findAll().map { heroDocument ->
            Hero(
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

    override fun findById(id: String): Optional<Hero> {
        return heroRepository.findById(id).map { heroDocument ->
            Hero(
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
}