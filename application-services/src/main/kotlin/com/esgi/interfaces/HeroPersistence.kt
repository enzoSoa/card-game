package com.esgi.interfaces

import com.esgi.Hero

interface HeroPersistence {
    fun insert(hero: Hero)
}