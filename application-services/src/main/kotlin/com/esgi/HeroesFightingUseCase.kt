package com.esgi

class HeroesFightingUseCase {
    private val heroesFightingService = HeroesFightingService()
    fun execute(attacker: Hero, defender: Hero): FightResult {
        if (attacker.level <= defender.level) {
            val fightWinner = heroesFightingService.execute(attacker, defender)
            return FightResult(attacker, defender, if (fightWinner == attacker) Fighter.ATTACKER else Fighter.DEFENDER)
        } else throw Exception("attacker level is too high to fight defender")
    }
}