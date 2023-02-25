package com.esgi.controllers

import com.esgi.HeroCreationUseCase
import com.esgi.HeroPersistence
import com.esgi.dto.CreateHeroRequest
import com.esgi.persistence.repositories.HeroRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("hero")
class HeroController(private val persistence: HeroRepository) {
    @PostMapping("")
    @ResponseBody
    fun createHero(@RequestBody request: CreateHeroRequest): String {
        val heroCreationUseCase = HeroCreationUseCase(persistence)
        heroCreationUseCase.execute(request.name, request.speciality, request.rarity)
        return "done"
    }
}