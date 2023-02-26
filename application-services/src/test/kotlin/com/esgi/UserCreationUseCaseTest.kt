package com.esgi

import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

class UserCreationUseCaseTest() {
    @Test
    fun `should execute user creation service and save user`() {
        val persistence = mock(UserPersistence::class.java)
        val useCase = UserCreationUseCase(persistence)
        val name = "Benoit"
        val expectedUser = User(name, 4, mutableListOf<Hero>())

        useCase.execute(name)

        verify(persistence).insert(expectedUser)
    }
}