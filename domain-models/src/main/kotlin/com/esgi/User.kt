package com.esgi

data class User(val nickname: String, var coins: Int, val deck: MutableList<Hero>)
