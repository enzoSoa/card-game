package com.esgi

import java.lang.Exception

class DeckOpeningUseCase() {
    val deckOpeningService = DeckOpeningService()

    private fun userHasEnoughCoin(coins: Int, type: DeckType): Boolean {
        return when(type) {
            DeckType.SILVER -> coins < 3
            DeckType.DIAMOND -> coins < 5
        }
    }

    fun execute(user: User, type: DeckType, hero: List<Hero>): User {
        if (userHasEnoughCoin(user.coins, type)) {
            val commonHeroes = hero.filter { it.rarity == Rarity.COMMON }
            val rareHeroes = hero.filter { it.rarity == Rarity.RARE }
            val legendaryHeroes = hero.filter { it.rarity == Rarity.LEGENDARY }

            val generatedDeck = deckOpeningService.execute(type, commonHeroes, rareHeroes, legendaryHeroes)

            return User(
                user.nickname,
                user.coins - if (type == DeckType.DIAMOND) 5 else 3,
                user.deck + generatedDeck
            )

        } else throw Exception("user don't have enough coins")
    }
}