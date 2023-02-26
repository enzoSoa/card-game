package com.esgi

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.RepetitionInfo
import org.junit.jupiter.api.Test

class DeckGenerationServiceTest {
    private val deckGenerationService = DeckGenerationService()
    private val heroA = Hero("Adrien", Speciality.TANK, Rarity.COMMON, 100.0, 2.0, 4.0)
    private val heroB = Hero("Bertrand", Speciality.MAGE, Rarity.LEGENDARY, 10000.0, 200.0, 400.0)


    @RepeatedTest(50)
    fun deck_is_generated_with_the_correct_amount_of_cards(repetitionInfo: RepetitionInfo) {
        val generatedDeck = deckGenerationService.execute(repetitionInfo.currentRepetition, listOf(
            DeckWithProbability(listOf(heroA), 50),
            DeckWithProbability(listOf(heroB), 50)
        ))

        Assertions.assertEquals(repetitionInfo.currentRepetition, generatedDeck.size)
    }

    @RepeatedTest(5)
    fun heroA_should_appear_9_times_less_than_heroB() {
        var iterationList = mutableListOf<Int>()
        for (i in 1..50) {
            val generatedDeck = deckGenerationService.execute(100, listOf(
                DeckWithProbability(listOf(heroA), 10),
                DeckWithProbability(listOf(heroB), 90)
            ))
            var heroACount = generatedDeck.count {hero -> hero == heroA }
            iterationList.add(heroACount)
        }
        val averageCount = iterationList.sum()/iterationList.size

        Assertions.assertTrue(averageCount in 0..20)
    }

    @RepeatedTest(5)
    fun deck_probability_should_almost_be_equal() {
        var iterationList = mutableListOf<Int>()
        for (i in 1..50) {
            val generatedDeck = deckGenerationService.execute(100, listOf(
                DeckWithProbability(listOf(heroA), 50),
                DeckWithProbability(listOf(heroB), 50)
            ))
            var heroACount = generatedDeck.count {hero -> hero == heroA }
            iterationList.add(heroACount)
        }
        val averageCount = iterationList.sum()/iterationList.size

        Assertions.assertTrue(averageCount in 40..60)
    }

    @RepeatedTest(5)
    fun heroA_should_appear_9_times_more_than_heroB() {
        var iterationList = mutableListOf<Int>()
        for (i in 1..50) {
            val generatedDeck = deckGenerationService.execute(100, listOf(
                DeckWithProbability(listOf(heroA), 90),
                DeckWithProbability(listOf(heroB), 10)
            ))
            var heroACount = generatedDeck.count {hero -> hero == heroA }
            iterationList.add(heroACount)
        }
        val averageCount = iterationList.sum()/iterationList.size

        Assertions.assertTrue(averageCount in 80..100)
    }
}