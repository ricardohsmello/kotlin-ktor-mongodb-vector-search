package com.mongodb.domain.service

import com.mongodb.infrastructure.repository.FitnessRepository
import com.mongodb.domain.entity.Fitness
import org.bson.BsonValue
import org.bson.types.ObjectId

class FitnessService(private val fitnessRepository: FitnessRepository) {

    suspend fun findAll() = fitnessRepository.findAll()

    suspend fun findById(objectId: ObjectId): Fitness? {
        return fitnessRepository.findById(objectId)
    }

    suspend fun findByExerciseType(type: String): List<Fitness> {
        return fitnessRepository.findByExerciseType(type)
    }

    suspend fun insertOne(fitness: Fitness): BsonValue? {
        return fitnessRepository.insertOne(fitness)
    }

    suspend fun deleteById(objectId: ObjectId): Long {
        return fitnessRepository.deleteById(objectId)
    }
    suspend fun updateOne(objectId: ObjectId, fitness: Fitness): Long {
        return fitnessRepository.updateOne(objectId, fitness)
    }


}


