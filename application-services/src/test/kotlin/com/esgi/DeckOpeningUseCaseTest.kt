package com.esgi

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.Exception

class DeckOpeningUseCaseTest() {
    private val heroA = Hero("Alfred", Speciality.TANK, Rarity.COMMON, 10.0, 10.0, 10.0, 0, 1)
    private val heroB = Hero("Batman", Speciality.TANK, Rarity.RARE, 100.0, 100.0, 100.0, 0, 1)
    private val heroC = Hero("Cat Woman", Speciality.TANK, Rarity.LEGENDARY, 1000.0, 1000.0, 1000.0, 0, 1)
    private val heroList = listOf<Hero>(heroA, heroB, heroC)

    private val deckOpeningUseCase = DeckOpeningUseCase()

    @Test
    fun user_should_open_silver_deck() {
        var user = User("didiLaMalice", 3, listOf())

        user = deckOpeningUseCase.execute(user, DeckType.SILVER, heroList)

        Assertions.assertEquals(0, user.coins)
        Assertions.assertEquals(3, user.deck.size)
    }

    @Test
    fun user_should_open_diamond_deck() {
        var user = User("didiLaMalice", 5, listOf())

        user = deckOpeningUseCase.execute(user, DeckType.DIAMOND, heroList)

        Assertions.assertEquals(0, user.coins)
        Assertions.assertEquals(5, user.deck.size)
    }
}