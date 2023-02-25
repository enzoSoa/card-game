package com.esgi.persistence

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoTemplate

@Configuration
open class MongoConfig {
    @Bean
    open fun mongoClient(): MongoClient {
        return MongoClients.create("mongodb+srv://mongo-clean:nrBvp1bhPRbAiWyv@cleancode.uhoviaa.mongodb.net/?retryWrites=true&w=majority")
    }

    @Bean
    open fun mongoTemplate(): MongoTemplate {
        return MongoTemplate(mongoClient(), "card_game_db")
    }
}