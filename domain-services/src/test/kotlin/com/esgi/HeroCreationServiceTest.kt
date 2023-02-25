package com.esgi

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HeroCreationServiceTest {
    private val heroCreationService = HeroCreationService()

    @Test
    fun hero_has_tank_stats() {
        val name = "Benoit"
        val speciality = Speciality.TANK
        val rarity = Rarity.COMMON

        val hero = heroCreationService.execute(name, speciality, rarity)

        Assertions.assertEquals(Hero(name, speciality, rarity, 1000.0, 100.0, 20.0), hero)
    }

    @Test
    fun hero_has_assassin_stats() {
        val name = "Benoit"
        val speciality = Speciality.ASSASSIN
        val rarity = Rarity.COMMON

        val hero = heroCreationService.execute(name, speciality, rarity)

        Assertions.assertEquals(Hero(name, speciality, rarity, 800.0, 200.0, 5.0), hero)
    }

    @Test
    fun hero_has_mage_stats() {
        val name = "Benoit"
        val speciality = Speciality.MAGE
        val rarity = Rarity.COMMON

        val hero = heroCreationService.execute(name, speciality, rarity)

        Assertions.assertEquals(Hero(name, speciality, rarity, 700.0, 150.0, 10.0), hero)
    }

    @Test
    fun rare_hero_gets_10_percent_boost() {
        val name = "Benoit"
        val speciality = Speciality.TANK
        val rarity = Rarity.RARE

        val hero = heroCreationService.execute(name, speciality, rarity)

        Assertions.assertEquals(Hero(name, speciality, rarity, 1100.0, 110.0, 22.0), hero)
    }

    @Test
    fun legendary_hero_gets_20_percent_boost() {
        val name = "Benoit"
        val speciality = Speciality.TANK
        val rarity = Rarity.LEGENDARY

        val hero = heroCreationService.execute(name, speciality, rarity)

        Assertions.assertEquals(Hero(name, speciality, rarity, 1200.0, 120.0, 24.0), hero)
    }
}