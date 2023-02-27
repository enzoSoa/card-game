package com.esgi

open class DeckOpeningService(private val deckGenerationService: DeckGenerationService) {

    open fun execute(type: DeckType, commonDeck: List<Hero>, rareDeck: List<Hero>, legendaryDeck: List<Hero>): List<Hero> {
        return when(type) {
            DeckType.SILVER -> deckGenerationService.execute(3, listOf(
                DeckWithProbability(commonDeck,75),
                DeckWithProbability(rareDeck,20),
                DeckWithProbability(legendaryDeck,5)
            ))
            DeckType.DIAMOND -> deckGenerationService.execute(5, listOf(
                DeckWithProbability(commonDeck,50),
                DeckWithProbability(rareDeck,35),
                DeckWithProbability(legendaryDeck,15)
            ))
        }
    }
}