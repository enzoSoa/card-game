package com.esgi

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class HeroDamagingServiceTest {
    private val heroDamagingService = HeroDamagingService()
    private val tank = Hero("tank", Speciality.TANK, Rarity.COMMON, 1000.0, 100.0, 20.0)
    private val assassin = Hero("assassin", Speciality.ASSASSIN, Rarity.COMMON, 1000.0, 100.0, 20.0)
    private val mage = Hero("mage", Speciality.MAGE, Rarity.COMMON, 1000.0, 100.0, 20.0)

    private val baseDamage = 100.0 - 20.0

    @Test
    fun tank_should_deal_20_more_damage_to_mage() {
        Assertions.assertEquals(baseDamage + 20.0, heroDamagingService.execute(tank,mage))
    }

    @Test
    fun assassin_should_deal_30_more_damage_to_tank() {
        Assertions.assertEquals(baseDamage + 30.0, heroDamagingService.execute(assassin, tank))
    }

    @Test
    fun mage_should_deal_25_more_damage_to_assassin() {
        Assertions.assertEquals(baseDamage + 25.0, heroDamagingService.execute(mage,assassin))
    }

}