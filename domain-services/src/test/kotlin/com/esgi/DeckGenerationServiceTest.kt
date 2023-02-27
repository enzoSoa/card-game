package com.esgi

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.RepetitionInfo
import org.mockito.Mockito
import org.mockito.Mockito.mock

class DeckGenerationServiceTest {
    private val chooseDeckService = mock(ChooseDeckService::class.java)

    private val deckGenerationService = DeckGenerationService(chooseDeckService)

    private val hero = Hero("Adrien", Speciality.TANK, Rarity.COMMON, 100.0, 2.0, 4.0)


    @RepeatedTest(10)
    fun deck_is_generated_with_the_correct_amount_of_cards(repetitionInfo: RepetitionInfo) {
        Mockito.`when`(chooseDeckService.execute(50, listOf(DeckWithProbability(listOf(hero), 50)))).thenReturn(DeckWithProbability(listOf(hero), 50))

        val generatedDeck = deckGenerationService.execute(repetitionInfo.currentRepetition, listOf(DeckWithProbability(listOf(hero), 50)))

        Assertions.assertEquals(repetitionInfo.currentRepetition, generatedDeck.size)
    }
}