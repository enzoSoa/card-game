package com.esgi

import com.esgi.persistence.HeroPersistence
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.*

class HeroCreationUseCaseTest {
    private val persistence = mock(HeroPersistence::class.java)
    private val heroCreationService = mock(HeroCreationService::class.java)

    private val heroCreationUseCase = HeroCreationUseCase(persistence, heroCreationService)

    @Test
    fun `should execute hero creation service and save hero`() {
        val name = "Benoit"
        val speciality = Speciality.TANK
        val rarity = Rarity.COMMON
        val expectedHero = Hero(name, speciality, rarity, 1000.0, 100.0, 20.0)

        Mockito.`when`(heroCreationService.execute(name, speciality, rarity)).thenReturn(expectedHero)
        heroCreationUseCase.execute(name, speciality, rarity)

        verify(persistence).insert(expectedHero)
    }
}