package com.esgi.persistence.repositories

import com.esgi.persistences.HeroPersistence
import com.esgi.persistence.documents.HeroDocument
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface HeroRepository : MongoRepository<HeroDocument, String>, HeroPersistence