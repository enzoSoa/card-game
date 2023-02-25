package com.esgi.controllers

import com.esgi.dto.CreateHeroRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("hero")
class HeroController {
    @PostMapping("")
    @ResponseBody
    fun createHero(@RequestBody request: CreateHeroRequest): String {
        return "${request.name} ${request.speciality} ${request.rarity}"
    }
}