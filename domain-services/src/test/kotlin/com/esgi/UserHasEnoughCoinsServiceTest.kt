package com.esgi

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.RepetitionInfo

class UserHasEnoughCoinsServiceTest {
    private val userHasEnoughCoinsService = UserHasEnoughCoinsService()

    @RepeatedTest(5)
    fun silver_deck_require_at_least_3_coins(repetitionInfo: RepetitionInfo) {
        val type = DeckType.SILVER
        val coins = repetitionInfo.currentRepetition


        Assertions.assertEquals(coins >= 3,userHasEnoughCoinsService.execute(coins, type))
    }

    @RepeatedTest(8)
    fun silver_deck_require_at_least_5_coins(repetitionInfo: RepetitionInfo) {
        val type = DeckType.DIAMOND
        val coins = repetitionInfo.currentRepetition


        Assertions.assertEquals(coins >= 5,userHasEnoughCoinsService.execute(coins, type))
    }
}