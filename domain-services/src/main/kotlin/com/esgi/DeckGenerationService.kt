package com.esgi

import kotlin.random.Random

data class DeckWithProbability (val deck: List<Hero>, val probability: Int)

class DeckGenerationService {
    private fun chooseDeckToPickFrom(probabilitySum: Int, possibleDecks: List<DeckWithProbability>): DeckWithProbability {
        val probabilityIndex = Random.nextInt(1, probabilitySum + 1)
        var seenProbability = 0

        for (deck in possibleDecks) {
            if (probabilityIndex < seenProbability + deck.probability)
                return deck
            seenProbability += deck.probability
        }
        return possibleDecks[possibleDecks.size - 1]
    }

    fun execute(size: Int,decks: List<DeckWithProbability>): List<Hero> {
        val sumOfProbabilities = decks.sumOf { it.probability }

        val generatedDeck = mutableListOf<Hero>()
        while (generatedDeck.size < size) {
            val pickedDeck = chooseDeckToPickFrom(sumOfProbabilities, decks)
            val hero = pickedDeck.deck[Random.nextInt(0, pickedDeck.deck.size)]
            generatedDeck.add(hero)
        }
        return generatedDeck
    }
}