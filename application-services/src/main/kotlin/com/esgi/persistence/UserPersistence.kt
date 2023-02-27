package com.esgi.persistence

import com.esgi.User
import java.util.*

interface UserPersistence {
    fun insert(user: User)
    fun findAll(): MutableList<User>
    fun findById(id: String): Optional<User>
    fun save(user: User)
}