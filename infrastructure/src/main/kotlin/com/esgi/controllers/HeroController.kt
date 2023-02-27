package com.esgi.controllers

import com.esgi.FindingAllHeroesUseCase
import com.esgi.FindingHeroByIdUseCase
import com.esgi.Hero
import com.esgi.HeroCreationUseCase
import com.esgi.dto.CreateHeroRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("hero")
class HeroController(
    private val heroCreationUseCase: HeroCreationUseCase,
    private val findingAllHeroesUseCase: FindingAllHeroesUseCase,
    private val findingHeroByIdUseCase: FindingHeroByIdUseCase
) {
    @PostMapping("")
    @ResponseBody
    fun createHero(@RequestBody request: CreateHeroRequest): String {
        heroCreationUseCase.execute(request.name, request.speciality, request.rarity)
        return "done"
    }

    @GetMapping("")
    @ResponseBody
    fun getHeroes(): List<Hero> {
        return findingAllHeroesUseCase.execute()
    }

    @GetMapping("{heroId}")
    @ResponseBody
    fun getHeroById(@PathVariable heroId: String): Hero {
        return findingHeroByIdUseCase.execute(heroId)
    }
}