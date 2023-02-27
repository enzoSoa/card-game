package com.esgi

import com.esgi.persistence.HeroPersistence
import com.esgi.persistence.UserPersistence

import java.lang.Exception

class DeckOpeningUseCase(
    private val deckOpeningService: DeckOpeningService,
    private val userHasEnoughCoinService: UserHasEnoughCoinsService,
    private val userPersistence: UserPersistence,
    private val heroPersistence: HeroPersistence,
) {

    fun execute(userId: String, deckType: DeckType): User {
        val user = userPersistence.findById(userId).orElseThrow {
            Error("No user with this id has been found")
        }

        val heroes: List<Hero> = heroPersistence.findAll()

        if (userHasEnoughCoinService.execute(user.coins, deckType)) {
            val commonHeroes = heroes.filter { it.rarity == Rarity.COMMON }
            val rareHeroes = heroes.filter { it.rarity == Rarity.RARE }
            val legendaryHeroes = heroes.filter { it.rarity == Rarity.LEGENDARY }

            val generatedDeck = deckOpeningService.execute(deckType, commonHeroes, rareHeroes, legendaryHeroes)

            val updatedUser = User(
                user.nickname,
                user.coins - if (deckType == DeckType.DIAMOND) 5 else 3,
                user.deck + generatedDeck
            )

            userPersistence.save(updatedUser)

            return updatedUser

        } else throw Exception("user don't have enough coins")
    }
}