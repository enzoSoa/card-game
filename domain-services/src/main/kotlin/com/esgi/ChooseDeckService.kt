package com.esgi

import kotlin.random.Random

open class ChooseDeckService {
    open fun execute(probabilitySum: Int, possibleDecks: List<DeckWithProbability>): DeckWithProbability {
        val probabilityIndex = Random.nextInt(1, probabilitySum + 1)
        var seenProbability = 0

        for (deck in possibleDecks) {
            if (probabilityIndex < seenProbability + deck.probability)
                return deck
            seenProbability += deck.probability
        }
        return possibleDecks[possibleDecks.size - 1]
    }
}