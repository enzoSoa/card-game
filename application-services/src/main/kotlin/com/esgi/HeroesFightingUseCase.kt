package com.esgi

import com.esgi.persistence.UserPersistence

class HeroesFightingUseCase(
    private val heroesFightingService: HeroesFightingService,
    private val userPersistence: UserPersistence
) {
    fun execute(attackerId: String, defenderId: String, attackerHeroIndex: Int, defenderHeroIndex: Int): FightResult {
        val attackerDocument = userPersistence.findById(attackerId).orElseThrow {
            Error("No attacker available with this id: $attackerId")
        }
        val defenderDocument = userPersistence.findById(defenderId).orElseThrow {
            Error("No defender available with this id: $defenderId")
        }

        val attacker = User(attackerDocument.nickname, attackerDocument.coins, attackerDocument.deck)
        val defender = User(defenderDocument.nickname, defenderDocument.coins, defenderDocument.deck)

        if (attacker.deck.size < attackerHeroIndex) throw Error("The hero index for attacker seems to be incorrect")
        else if (defender.deck.size < defenderHeroIndex) throw Error("The hero index for defender seems to be incorrect")

        val attackerHero = attacker.deck[attackerHeroIndex]
        val defenderHero = defender.deck[defenderHeroIndex]

        if (attackerHero.level <= defenderHero.level) {
            val fightWinner = heroesFightingService.execute(attackerHero, defenderHero)
            return FightResult(attackerHero, defenderHero, if (fightWinner == attackerHero) Fighter.ATTACKER else Fighter.DEFENDER)
        } else throw Exception("attacker level is too high to fight defender")
    }
}