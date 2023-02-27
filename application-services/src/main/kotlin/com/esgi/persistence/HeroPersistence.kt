package com.esgi.persistence

import com.esgi.Hero
import java.util.*

interface HeroPersistence {
    fun insert(hero: Hero)
    fun findAll(): List<Hero>
    fun findById(id: String): Optional<Hero>
}