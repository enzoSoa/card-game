package com.esgi.interfaces

import com.esgi.User

interface UserPersistence {
    fun insert(user: User)
}