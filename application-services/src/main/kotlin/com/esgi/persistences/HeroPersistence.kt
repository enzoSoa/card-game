package com.esgi.persistences

import com.esgi.Hero

interface HeroPersistence {
    fun insert(hero: Hero)
}