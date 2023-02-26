package com.esgi

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class HeroesFightingUseCaseTest {
    private val heroesFightingUseCase = HeroesFightingUseCase()
    private val heroA = Hero("hulk", Speciality.TANK, Rarity.COMMON, 1000.0, 100.0, 20.0, level = 10)
    private val heroB = Hero("aunt may", Speciality.MAGE, Rarity.COMMON, 1000000.0, 1000.0, 100.0)

    @Test
    fun attacker_should_win() {
        Assertions.assertEquals(Fighter.ATTACKER, heroesFightingUseCase.execute(heroB, heroA).winner)
    }
}