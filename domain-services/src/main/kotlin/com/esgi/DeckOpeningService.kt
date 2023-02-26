package com.esgi

class DeckOpeningService(private val commonDeck: List<Hero>,
                         private val rareDeck: List<Hero>,
                         private val legendaryDeck: List<Hero>) {
    private val deckGenerationService = DeckGenerationService()

    fun execute(type: DeckType): List<Hero> {
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