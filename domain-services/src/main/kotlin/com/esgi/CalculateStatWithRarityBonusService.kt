package com.esgi

import java.math.BigDecimal
import java.math.MathContext

open class CalculateStatWithRarityBonusService {
    open fun execute(stat: Double, rarity: Rarity): Double {
        return when (rarity) {
            Rarity.COMMON -> stat
            Rarity.RARE -> BigDecimal(stat).multiply(BigDecimal(1.1), MathContext(2)).toDouble()
            Rarity.LEGENDARY -> BigDecimal(stat).multiply(BigDecimal(1.2), MathContext(2)).toDouble()
        }
    }
}