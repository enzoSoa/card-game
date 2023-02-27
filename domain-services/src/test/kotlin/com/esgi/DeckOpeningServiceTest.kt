package com.esgi

import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class DeckOpeningServiceTest {
    private val deckGenerationService = mock(DeckGenerationService::class.java)

    private val deckOpeningService = DeckOpeningService(deckGenerationService)

    private val heroA = Hero("Alfred", Speciality.TANK, Rarity.COMMON, 10.0, 10.0, 10.0, 0, 1)
    private val heroB = Hero("Batman", Speciality.TANK, Rarity.RARE, 100.0, 100.0, 100.0, 0, 1)
    private val heroC = Hero("Cat Woman", Speciality.TANK, Rarity.LEGENDARY, 1000.0, 1000.0, 1000.0, 0, 1)

    @Test
    fun silver_deck_should_be_generated() {
        deckOpeningService.execute(DeckType.SILVER, listOf(heroA), listOf(heroB), listOf(heroC))

        verify(deckGenerationService).execute(3, listOf(
            DeckWithProbability(listOf(heroA),75),
            DeckWithProbability(listOf(heroB),20),
            DeckWithProbability(listOf(heroC),5)
        ))
    }

    @Test
    fun diamond_deck_should_have_5_cards() {
        deckOpeningService.execute(DeckType.DIAMOND, listOf(heroA), listOf(heroB), listOf(heroC))

        verify(deckGenerationService).execute(5, listOf(
            DeckWithProbability(listOf(heroA),50),
            DeckWithProbability(listOf(heroB),35),
            DeckWithProbability(listOf(heroC),15)
        ))
    }
}