package com.esgi

open class HeroCreationService(private val calculateStatWithRarityBonusService: CalculateStatWithRarityBonusService) {
    open fun execute(name: String, speciality: Speciality, rarity: Rarity): Hero {
        val hp: Double
        val power: Double
        val armor: Double

        when(speciality) {
            Speciality.TANK -> {
                hp = calculateStatWithRarityBonusService.execute(1000.0, rarity)
                power = calculateStatWithRarityBonusService.execute(100.0, rarity)
                armor = calculateStatWithRarityBonusService.execute(20.0, rarity)
            }
            Speciality.ASSASSIN -> {
                hp = calculateStatWithRarityBonusService.execute(800.0, rarity)
                power = calculateStatWithRarityBonusService.execute(200.0, rarity)
                armor = calculateStatWithRarityBonusService.execute(5.0, rarity)
            }
            Speciality.MAGE -> {
                hp = calculateStatWithRarityBonusService.execute(700.0, rarity)
                power = calculateStatWithRarityBonusService.execute(150.0, rarity)
                armor = calculateStatWithRarityBonusService.execute(10.0, rarity)
            }
        }

        return Hero(name, speciality, rarity, hp, power, armor)
    }
}