package com.esgi

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test

class DeckOpeningServiceTest {
    private val heroA = Hero("Alfred", Speciality.TANK, Rarity.COMMON, 10.0, 10.0, 10.0, 0, 1)
    private val heroB = Hero("Batman", Speciality.TANK, Rarity.RARE, 100.0, 100.0, 100.0, 0, 1)
    private val heroC = Hero("Cat Woman", Speciality.TANK, Rarity.LEGENDARY, 1000.0, 1000.0, 1000.0, 0, 1)
    private val deckOpeningService = DeckOpeningService()

    @RepeatedTest(5)
    fun deck_should_have_silver_apparition_rate() {
        var commonCount = 0
        var rareCount = 0
        var legendaryCount = 0

        for (i in 1..100) {
            val openedDeck = deckOpeningService.execute(DeckType.SILVER, listOf(heroA), listOf(heroB), listOf(heroC))

            commonCount += openedDeck.count {it == heroA}
            rareCount += openedDeck.count {it == heroB}
            legendaryCount += openedDeck.count {it == heroC}
        }

        val totalCount = (commonCount + rareCount + legendaryCount).toDouble()

        val commonProportion = (commonCount).toDouble() / totalCount
        val rareProportion = (rareCount).toDouble() / totalCount
        val legendaryProportion = (legendaryCount).toDouble() / totalCount

        Assertions.assertTrue(commonProportion in 0.65..0.85)
        Assertions.assertTrue(rareProportion in 0.1..0.3)
        Assertions.assertTrue(legendaryProportion in 0.0..0.15)
    }

    @RepeatedTest(5)
    fun deck_should_have_diamond_apparition_rate() {
        var commonCount = 0
        var rareCount = 0
        var legendaryCount = 0

        for (i in 1..100) {
            val openedDeck = deckOpeningService.execute(DeckType.DIAMOND, listOf(heroA), listOf(heroB), listOf(heroC))

            commonCount += openedDeck.count {it == heroA}
            rareCount += openedDeck.count {it == heroB}
            legendaryCount += openedDeck.count {it == heroC}
        }

        val totalCount = (commonCount + rareCount + legendaryCount).toDouble()

        val commonProportion = (commonCount).toDouble() / totalCount
        val rareProportion = (rareCount).toDouble() / totalCount
        val legendaryProportion = (legendaryCount).toDouble() / totalCount

        Assertions.assertTrue(commonProportion in 0.4..0.6)
        Assertions.assertTrue(rareProportion in 0.25..0.45)
        Assertions.assertTrue(legendaryProportion in 0.05..0.25)
    }

    @Test
    fun silver_deck_should_have_3_cards() {
        val openedDeck = deckOpeningService.execute(DeckType.SILVER, listOf(heroA), listOf(heroB), listOf(heroC))
        Assertions.assertEquals(3, openedDeck.size)
    }

    @Test
    fun diamond_deck_should_have_5_cards() {
        val openedDeck = deckOpeningService.execute(DeckType.DIAMOND, listOf(heroA), listOf(heroB), listOf(heroC))
        Assertions.assertEquals(5, openedDeck.size)
    }
}