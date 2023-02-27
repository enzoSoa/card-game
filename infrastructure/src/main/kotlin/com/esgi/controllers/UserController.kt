package com.esgi.controllers

import com.esgi.*
import com.esgi.dto.CreateUserRequest
import com.esgi.dto.FightingRequest
import com.esgi.dto.OpenDeckRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("user")
class UserController(
    private val userCreationUseCase: UserCreationUseCase,
    private val heroesFightingUseCase: HeroesFightingUseCase,
    private val deckOpeningUseCase: DeckOpeningUseCase,
    private val findingAllUsersUseCase: FindingAllUsersUseCase,
    private val findingUserByIdUseCase: FindingUserByIdUseCase,
    private val findingUserDeckUseCase: FindingUserDeckUseCase,
) {
    @PostMapping("")
    @ResponseBody
    fun createUser(@RequestBody request:CreateUserRequest): String {
        userCreationUseCase.execute(request.nickname)
        return "done"
    }

    @GetMapping("")
    @ResponseBody
    fun getUsers(): List<User> {
        return findingAllUsersUseCase.execute()
    }

    @GetMapping("{userId}")
    @ResponseBody
    fun getUserById(@PathVariable userId: String): User {
        return findingUserByIdUseCase.execute(userId)
    }

    @GetMapping("{userId}/deck")
    @ResponseBody
    fun getUserDeck(@PathVariable userId: String): List<Hero> {
        return findingUserDeckUseCase.execute(userId)
    }

    @PatchMapping("{userId}/deck")
    @ResponseBody
    fun openDeck(@PathVariable userId: String, @RequestBody request: OpenDeckRequest): User {
        return deckOpeningUseCase.execute(userId, request.type)
    }

    @PostMapping("{attackerId}/fight")
    @ResponseBody
    fun fight(@PathVariable attackerId: String, @RequestBody request: FightingRequest): FightResult {
        return heroesFightingUseCase.execute(
            attackerId,
            request.defenderId,
            request.attackerHeroIndex,
            request.defenderHeroIndex
        )
    }
}