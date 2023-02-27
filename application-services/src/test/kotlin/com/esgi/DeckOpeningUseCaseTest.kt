package com.esgi

import com.esgi.persistence.HeroPersistence
import com.esgi.persistence.UserPersistence
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import java.util.*

class DeckOpeningUseCaseTest {
    private val deckOpeningService = mock(DeckOpeningService::class.java)
    private val userHasEnoughCoinsService = mock(UserHasEnoughCoinsService::class.java)
    private val heroPersistence = mock(HeroPersistence::class.java)
    private val userPersistence = mock(UserPersistence::class.java)

    private val deckOpeningUseCase = DeckOpeningUseCase(deckOpeningService, userHasEnoughCoinsService, userPersistence, heroPersistence)

    private val heroA = Hero("Alfred", Speciality.TANK, Rarity.COMMON, 10.0, 10.0, 10.0, 0, 1)
    private val heroB = Hero("Batman", Speciality.TANK, Rarity.RARE, 100.0, 100.0, 100.0, 0, 1)
    private val heroC = Hero("Cat Woman", Speciality.TANK, Rarity.LEGENDARY, 1000.0, 1000.0, 1000.0, 0, 1)
    private val heroList = listOf(heroA, heroB, heroC)

    @Test
    fun user_should_open_silver_deck() {
        var user = User("didiLaMalice", 3, listOf())

        Mockito.`when`(userPersistence.findById("id")).thenReturn(Optional.of(user))
        Mockito.`when`(heroPersistence.findAll()).thenReturn(heroList)
        Mockito.`when`(userHasEnoughCoinsService.execute(3,DeckType.SILVER)).thenReturn(true)
        Mockito.`when`(deckOpeningService.execute(DeckType.SILVER, listOf(heroA), listOf(heroB), listOf(heroC))).thenReturn(listOf(heroA,heroA,heroA))
        user = deckOpeningUseCase.execute("id", DeckType.SILVER)

        Assertions.assertEquals(0, user.coins)
        Assertions.assertEquals(3, user.deck.size)
    }

    @Test
    fun user_should_open_diamond_deck() {
        var user = User("didiLaMalice", 5, listOf())

        Mockito.`when`(userPersistence.findById("id")).thenReturn(Optional.of(user))
        Mockito.`when`(heroPersistence.findAll()).thenReturn(heroList)
        Mockito.`when`(userHasEnoughCoinsService.execute(5,DeckType.DIAMOND)).thenReturn(true)
        Mockito.`when`(deckOpeningService.execute(DeckType.DIAMOND, listOf(heroA), listOf(heroB), listOf(heroC))).thenReturn(listOf(heroA,heroA,heroA,heroA,heroA))
        user = deckOpeningUseCase.execute("id", DeckType.DIAMOND)

        Assertions.assertEquals(0, user.coins)
        Assertions.assertEquals(5, user.deck.size)
    }
}