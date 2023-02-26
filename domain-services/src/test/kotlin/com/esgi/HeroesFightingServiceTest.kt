package com.esgi

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class HeroesFightingServiceTest {
    private val heroesFightingService = HeroesFightingService()
    private val heroA = Hero("hulk", Speciality.TANK, Rarity.COMMON, 1000.0, 100.0, 20.0)
    private val heroB = Hero("aunt may", Speciality.MAGE, Rarity.COMMON, 1000000.0, 1000.0, 100.0)

    @Test
    fun attacker_should_win() {
        Assertions.assertEquals(heroB, heroesFightingService.execute(heroB, heroA))
    }

    @Test
    fun defender_should_win() {
        Assertions.assertEquals(heroB, heroesFightingService.execute(heroA, heroB))
    }
}