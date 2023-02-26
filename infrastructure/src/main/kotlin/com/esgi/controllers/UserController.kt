package com.esgi.controllers

import com.esgi.DeckOpeningUseCase
import com.esgi.Hero
import com.esgi.UserCreationUseCase
import com.esgi.dto.CreateUserRequest
import com.esgi.dto.OpenDeckRequest
import com.esgi.exceptions.NotFoundException
import com.esgi.persistence.documents.UserDocument
import com.esgi.persistence.repositories.HeroRepository
import com.esgi.persistence.repositories.UserRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("user")
class UserController(private val persistence: UserRepository, private val heroPersistence: HeroRepository) {
    @PostMapping("")
    @ResponseBody
    fun createUser(@RequestBody request:CreateUserRequest): String {
        val userCreationUseCase = UserCreationUseCase(persistence)
        userCreationUseCase.execute(request.nickname)
        return "done"
    }

    @GetMapping("")
    @ResponseBody
    fun getUsers(): List<UserDocument> {
        return persistence.findAll()
    }

    @GetMapping("{userId}")
    @ResponseBody
    fun getUserById(@PathVariable userId: String): UserDocument {
        val user = persistence.findById(userId)
        if (user.isEmpty) throw NotFoundException("No user with this id has been found")
        return persistence.findById(userId).get()
    }

    @GetMapping("{userId}/deck")
    @ResponseBody
    fun getUserDeck(@PathVariable userId: String): List<Hero> {
        val user = persistence.findById(userId)
        if (user.isEmpty) throw NotFoundException("No user with this id has been found")
        return user.get().deck
    }

    @PatchMapping("{userId}/deck")
    @ResponseBody
    fun openDeck(@PathVariable userId: String, @RequestBody request: OpenDeckRequest): UserDocument {
        val userDocument = persistence.findById(userId)
        if (userDocument.isEmpty) throw NotFoundException("No user with this id has been found")

        val user = userDocument.get()
        val heroes: List<Hero> = heroPersistence.findAll().map {
            Hero(it.name, it.speciality, it.rarity, it.hp, it.power, it.armor, it.exp, it.level)
        }

        val userNewState = DeckOpeningUseCase().execute(user.toUser(), request.type, heroes)

        user.coins = userNewState.coins
        user.deck = userNewState.deck

        return persistence.save(user)
    }
}