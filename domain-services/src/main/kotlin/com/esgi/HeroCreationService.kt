package com.esgi

import java.math.BigDecimal
import java.math.MathContext

class HeroCreationService() {
    private fun calculateStatWithRarityBonus(stat: Double, rarity: Rarity): Double {
        return when (rarity) {
            Rarity.COMMON -> stat
            Rarity.RARE -> BigDecimal(stat).multiply(BigDecimal(1.1), MathContext(2)).toDouble()
            Rarity.LEGENDARY -> BigDecimal(stat).multiply(BigDecimal(1.2), MathContext(2)).toDouble()
        }
    }

    fun execute(name: String, speciality: Speciality, rarity: Rarity): Hero {
        val hp: Double
        val power: Double
        val armor: Double

        when(speciality) {
            Speciality.TANK -> {
                hp = calculateStatWithRarityBonus(1000.0, rarity)
                power = calculateStatWithRarityBonus(100.0, rarity)
                armor = calculateStatWithRarityBonus(20.0, rarity)
            }
            Speciality.ASSASSIN -> {
                hp = calculateStatWithRarityBonus(800.0, rarity)
                power = calculateStatWithRarityBonus(200.0, rarity)
                armor = calculateStatWithRarityBonus(5.0, rarity)
            }
            Speciality.MAGE -> {
                hp = calculateStatWithRarityBonus(700.0, rarity)
                power = calculateStatWithRarityBonus(150.0, rarity)
                armor = calculateStatWithRarityBonus(10.0, rarity)
            }
        }

        return Hero(name, speciality, rarity, hp, power, armor)
    }
}