package com.esgi.persistence.repositories

import com.esgi.Hero
import com.esgi.HeroPersistence
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface HeroRepository : MongoRepository<Hero, String>, HeroPersistence