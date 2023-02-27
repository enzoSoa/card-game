package com.esgi

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock

class HeroesFightingServiceTest {
    private val heroDamagingService = mock(HeroDamagingService::class.java)

    private val heroesFightingService = HeroesFightingService(heroDamagingService)

    private val heroA = Hero("hulk", Speciality.TANK, Rarity.COMMON, 1000.0, 100.0, 20.0)
    private val heroB = Hero("aunt may", Speciality.TANK, Rarity.COMMON, 1000.0, 100.0, 20.0)

    @Test
    fun attacker_should_beat_defender() {
        Mockito.`when`(heroDamagingService.execute(heroB, heroA)).thenReturn(3.0)
        Mockito.`when`(heroDamagingService.execute(heroA, heroB)).thenReturn(0.0)

        Assertions.assertEquals(heroB, heroesFightingService.execute(heroB, heroA))
    }

    @Test
    fun defender_should_beat_attacker() {
        Mockito.`when`(heroDamagingService.execute(heroA, heroB)).thenReturn(0.0)
        Mockito.`when`(heroDamagingService.execute(heroB, heroA)).thenReturn(3.0)

        Assertions.assertEquals(heroB, heroesFightingService.execute(heroA, heroB))
    }
}