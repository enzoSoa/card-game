package com.esgi

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class UserCreationServiceTest {
    private val user = UserCreationService().execute("damien")

    @Test
    fun user_created_with_4_coins() {
        Assertions.assertEquals(4, user.coins)
    }

    @Test
    fun user_created_with_empty_deck() {
        Assertions.assertTrue(user.deck.isEmpty())
    }
}