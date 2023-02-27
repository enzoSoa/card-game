package com.esgi

import kotlin.random.Random

open class DeckGenerationService(private val chooseDeckService: ChooseDeckService) {
    open fun execute(size: Int,decks: List<DeckWithProbability>): List<Hero> {
        val sumOfProbabilities = decks.sumOf { it.probability }

        val generatedDeck = mutableListOf<Hero>()
        while (generatedDeck.size < size) {
            val pickedDeck = chooseDeckService.execute(sumOfProbabilities, decks)
            val hero = pickedDeck.deck[Random.nextInt(0, pickedDeck.deck.size)]
            generatedDeck.add(hero)
        }
        return generatedDeck
    }
}