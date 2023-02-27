package com.esgi

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.RepetitionInfo

class ChooseDeckServiceTest {
    private val chooseDeckService = ChooseDeckService()

    private val heroA = Hero("Athos", Speciality.TANK, Rarity.COMMON, 1000.0, 100.0, 20.0)
    private val heroB = Hero("Bob", Speciality.TANK, Rarity.COMMON, 1000.0, 100.0, 20.0)

    @RepeatedTest(10)
    fun generated_test_should_conform_to_probabilities(repetitionInfo: RepetitionInfo) {
        val heroAProbability = repetitionInfo.currentRepetition * 10
        val heroBProbability = 100 - heroAProbability

        val heroADeck = DeckWithProbability(listOf(heroA), heroAProbability)
        val heroBDeck = DeckWithProbability(listOf(heroB), heroBProbability)

        var heroACount = 0
        var heroBCount = 0

        for (i in 0..100){
            val chosenDeck = chooseDeckService.execute(100, listOf(heroADeck, heroBDeck))
            if (chosenDeck == heroADeck) heroACount++
            else heroBCount++
        }

        val totalCount = (heroACount + heroBCount).toDouble()

        val heroAProportion = (heroACount).toDouble() / totalCount
        val heroBProportion = (heroBCount).toDouble() / totalCount

        Assertions.assertTrue(heroAProportion in heroAProbability.toDouble() / 100.0 - 0.1..heroAProbability.toDouble() / 100.0 + 0.1)
        Assertions.assertTrue(heroBProportion in heroBProbability.toDouble() / 100.0 - 0.1..heroBProbability.toDouble() / 100.0 + 0.1)

    }
}