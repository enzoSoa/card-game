package com.esgi

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.math.MathContext

open class CalculateStatWithRarityBonusServiceTest {
    private val calculateStatWithRarityBonusService = CalculateStatWithRarityBonusService()

    @Test
    fun common_should_not_get_boosted() {
        Assertions.assertEquals(100.0, calculateStatWithRarityBonusService.execute(100.0, Rarity.COMMON))
    }

    @Test
    fun rare_should_get_a_10_percent_boost() {
        Assertions.assertEquals(110.0, calculateStatWithRarityBonusService.execute(100.0, Rarity.RARE))
    }

    @Test
    fun legendary_should_get_a_20_percent_boost() {
        Assertions.assertEquals(120.0, calculateStatWithRarityBonusService.execute(100.0, Rarity.LEGENDARY))
    }
}