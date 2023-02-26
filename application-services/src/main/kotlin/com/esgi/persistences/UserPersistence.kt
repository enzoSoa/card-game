package com.esgi.persistences

import com.esgi.User

interface UserPersistence {
    fun insert(user: User)
}