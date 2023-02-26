package com.esgi.controllers

import com.esgi.Hero
import com.esgi.UserCreationUseCase
import com.esgi.dto.CreateUserRequest
import com.esgi.persistence.documents.UserDocument
import com.esgi.persistence.repositories.UserRepository
import org.springframework.web.bind.annotation.*
import java.util.Optional

@RestController
@RequestMapping("user")
class UserController(private val persistence: UserRepository) {
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
    fun getUserById(@PathVariable userId: String): Optional<UserDocument> {
        return persistence.findById(userId)
    }
}