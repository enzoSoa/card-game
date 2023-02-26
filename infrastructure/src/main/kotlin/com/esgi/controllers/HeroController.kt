package com.esgi.controllers

import com.esgi.HeroCreationUseCase
import com.esgi.dto.CreateHeroRequest
import com.esgi.persistence.documents.HeroDocument
import com.esgi.persistence.repositories.HeroRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

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

    @GetMapping("")
    @ResponseBody
    fun getHeroes(): List<HeroDocument> {
        return persistence.findAll()
    }

    @GetMapping("{heroId}")
    @ResponseBody
    fun getHeroById(@PathVariable heroId: String): Optional<HeroDocument> {
        return persistence.findById(heroId)
    }
}