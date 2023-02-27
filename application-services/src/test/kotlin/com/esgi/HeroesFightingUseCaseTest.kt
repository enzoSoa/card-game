package com.esgi

import com.esgi.persistence.UserPersistence
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.*
import java.util.*

class HeroesFightingUseCaseTest {
    private val heroesFightingService = mock(HeroesFightingService::class.java)
    private val userPersistence = mock(UserPersistence::class.java)

    private val heroesFightingUseCase = HeroesFightingUseCase(heroesFightingService, userPersistence)

    private val heroA = Hero("hulk", Speciality.TANK, Rarity.COMMON, 1000.0, 100.0, 20.0, level = 10)
    private val heroB = Hero("aunt may", Speciality.MAGE, Rarity.COMMON, 1000000.0, 1000.0, 100.0)

    @Test
    fun attacker_should_win() {
        // Assertions.assertEquals(Fighter.ATTACKER, heroesFightingUseCase.execute(heroB, heroA).winner)
    }
}