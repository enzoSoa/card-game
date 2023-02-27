package com.esgi.persistence.repositories

import com.esgi.persistence.documents.UserDocument
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : MongoRepository<UserDocument, String>