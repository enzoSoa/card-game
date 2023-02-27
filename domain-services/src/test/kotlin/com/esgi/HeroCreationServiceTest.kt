package com.esgi

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.mockito.Mockito
import org.mockito.Mockito.mock

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HeroCreationServiceTest {
    private val calculateStatWithRarityBonusService = mock(CalculateStatWithRarityBonusService::class.java)

    private val heroCreationService = HeroCreationService(calculateStatWithRarityBonusService)

    @Test
    fun hero_has_tank_stats() {
        val name = "Benoit"
        val speciality = Speciality.TANK
        val rarity = Rarity.COMMON

        Mockito.`when`(calculateStatWithRarityBonusService.execute(1000.0, rarity)).thenReturn(1000.0)
        Mockito.`when`(calculateStatWithRarityBonusService.execute(100.0, rarity)).thenReturn(100.0)
        Mockito.`when`(calculateStatWithRarityBonusService.execute(20.0, rarity)).thenReturn(20.0)
        val hero = heroCreationService.execute(name, speciality, rarity)

        Assertions.assertEquals(Hero(name, speciality, rarity, 1000.0, 100.0, 20.0), hero)
    }

    @Test
    fun hero_has_assassin_stats() {
        val name = "Benoit"
        val speciality = Speciality.ASSASSIN
        val rarity = Rarity.COMMON

        Mockito.`when`(calculateStatWithRarityBonusService.execute(800.0, rarity)).thenReturn(800.0)
        Mockito.`when`(calculateStatWithRarityBonusService.execute(200.0, rarity)).thenReturn(200.0)
        Mockito.`when`(calculateStatWithRarityBonusService.execute(5.0, rarity)).thenReturn(5.0)
        val hero = heroCreationService.execute(name, speciality, rarity)

        Assertions.assertEquals(Hero(name, speciality, rarity, 800.0, 200.0, 5.0), hero)
    }

    @Test
    fun hero_has_mage_stats() {
        val name = "Benoit"
        val speciality = Speciality.MAGE
        val rarity = Rarity.COMMON

        Mockito.`when`(calculateStatWithRarityBonusService.execute(700.0, rarity)).thenReturn(700.0)
        Mockito.`when`(calculateStatWithRarityBonusService.execute(150.0, rarity)).thenReturn(150.0)
        Mockito.`when`(calculateStatWithRarityBonusService.execute(10.0, rarity)).thenReturn(10.0)
        val hero = heroCreationService.execute(name, speciality, rarity)

        Assertions.assertEquals(Hero(name, speciality, rarity, 700.0, 150.0, 10.0), hero)
    }
}