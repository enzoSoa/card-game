package com.esgi

import com.esgi.persistence.adapters.HeroPersistenceAdapter
import com.esgi.persistence.adapters.UserPersistenceAdapter
import com.esgi.persistence.repositories.HeroRepository
import com.esgi.persistence.repositories.UserRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class ApplicationConfiguration(
    private val userRepository: UserRepository,
    private val heroRepository: HeroRepository
) {
    @Bean
    open fun userPersistence(): UserPersistenceAdapter {
        return UserPersistenceAdapter(userRepository)
    }

    @Bean
    open fun heroPersistence(): HeroPersistenceAdapter {
        return HeroPersistenceAdapter(heroRepository)
    }

    @Bean
    open fun userCreationService(): UserCreationService {
        return UserCreationService()
    }

    @Bean
    open fun userCreationUseCase(): UserCreationUseCase {
        return UserCreationUseCase(
            userPersistence(),
            userCreationService()
        )
    }

    @Bean
    open fun heroDamagingService(): HeroDamagingService {
        return HeroDamagingService()
    }

    @Bean
    open fun heroesFightingService(): HeroesFightingService {
        return HeroesFightingService(heroDamagingService())
    }

    @Bean
    open fun heroesFightingUseCase(): HeroesFightingUseCase {
        return HeroesFightingUseCase(
            heroesFightingService(),
            userPersistence()
        )
    }

    @Bean
    open fun calculateStatWithRarityBonusService(): CalculateStatWithRarityBonusService {
        return CalculateStatWithRarityBonusService()
    }

    @Bean
    open fun heroesCreationService(): HeroCreationService {
        return HeroCreationService(calculateStatWithRarityBonusService())
    }

    @Bean
    open fun userHasEnoughCoinsService(): UserHasEnoughCoinsService {
        return UserHasEnoughCoinsService()
    }

    @Bean
    open fun chooseDeckService(): ChooseDeckService {
        return ChooseDeckService()
    }

    @Bean
    open fun deckGenerationService(): DeckGenerationService {
        return DeckGenerationService(
            chooseDeckService(),
        )
    }

    @Bean
    open fun deckOpeningService(): DeckOpeningService {
        return DeckOpeningService(
            deckGenerationService()
        )
    }

    @Bean
    open fun heroCreationUseCase(): HeroCreationUseCase {
        return HeroCreationUseCase(
            heroPersistence(),
            heroesCreationService()
        )
    }

    @Bean
    open fun findingAllHeroesUseCase(): FindingAllHeroesUseCase {
        return FindingAllHeroesUseCase(
            heroPersistence()
        )
    }

    @Bean
    open fun findingHeroByIdUseCase(): FindingHeroByIdUseCase {
        return FindingHeroByIdUseCase(
            heroPersistence()
        )
    }

    @Bean
    open fun deckOpeningUseCase(): DeckOpeningUseCase {
        return DeckOpeningUseCase(
            deckOpeningService(),
            userHasEnoughCoinsService(),
            userPersistence(),
            heroPersistence()
        )
    }

    @Bean
    open fun findingAllUsersUseCase(): FindingAllUsersUseCase {
        return FindingAllUsersUseCase(
            userPersistence()
        )
    }

    @Bean
    open fun findingUserByIdUseCase(): FindingUserByIdUseCase {
        return FindingUserByIdUseCase(
            userPersistence()
        )
    }

    @Bean
    open fun findingUserDeckUseCase(): FindingUserDeckUseCase {
        return FindingUserDeckUseCase(
            userPersistence()
        )
    }

}