package com.esgi

open class UserHasEnoughCoinsService {
    open fun execute(coins: Int, type: DeckType): Boolean {
        return when(type) {
            DeckType.SILVER -> coins >= 3
            DeckType.DIAMOND -> coins >= 5
        }
    }
}