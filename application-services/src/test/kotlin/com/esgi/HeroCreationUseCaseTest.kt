package com.esgi

import com.esgi.interfaces.HeroPersistence
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

class HeroCreationUseCaseTest() {
    @Test
    fun `should execute hero creation service and save hero`() {
        val persistence = mock(HeroPersistence::class.java)
        val useCase = HeroCreationUseCase(persistence)
        val name = "Benoit"
        val speciality = Speciality.TANK
        val rarity = Rarity.COMMON
        val expectedHero = Hero(name, speciality, rarity, 1000.0, 100.0, 20.0)

        useCase.execute(name, speciality, rarity)

        verify(persistence).insert(expectedHero)
    }
}