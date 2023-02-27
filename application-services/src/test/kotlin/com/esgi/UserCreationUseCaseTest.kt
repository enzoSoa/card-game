package com.esgi

import com.esgi.persistence.UserPersistence
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class UserCreationUseCaseTest {
    private val persistence = mock(UserPersistence::class.java)
    private val userCreationService = mock(UserCreationService::class.java)

    private val userCreationUseCase = UserCreationUseCase(persistence, userCreationService)

    @Test
    fun `should execute user creation service and save user`() {
        val name = "Benoit"
        val expectedUser = User(name, 4, mutableListOf())

        Mockito.`when`(userCreationService.execute("Benoit")).thenReturn(expectedUser)

        userCreationUseCase.execute(name)

        verify(persistence).insert(expectedUser)
    }
}