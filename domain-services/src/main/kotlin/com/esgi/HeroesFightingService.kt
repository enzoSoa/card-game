package com.esgi

class HeroesFightingService {
    private val heroDamagingService = HeroDamagingService()

    fun execute(attacker: Hero, defender: Hero): Hero {
        val attackerWinTurnCount = defender.hp / heroDamagingService.execute(attacker, defender)
        val defenderWinTurnCount = defender.hp / heroDamagingService.execute(defender, attacker)

        println(attackerWinTurnCount)
        println(defenderWinTurnCount)

        return if (attackerWinTurnCount < defenderWinTurnCount) attacker else defender
    }
}