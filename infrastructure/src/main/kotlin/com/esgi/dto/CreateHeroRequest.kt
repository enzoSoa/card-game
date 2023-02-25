package com.esgi.dto

import com.esgi.Rarity
import com.esgi.Speciality

data class CreateHeroRequest(val name: String, val speciality: Speciality, val rarity: Rarity)