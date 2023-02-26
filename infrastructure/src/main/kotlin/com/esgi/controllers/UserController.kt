package com.esgi.controllers

import com.esgi.UserCreationUseCase
import com.esgi.dto.CreateUserRequest
import com.esgi.persistence.repositories.UserRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

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
}