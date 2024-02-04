package com.mongodb.infrastructure.repository

import com.mongodb.client.model.Filters.eq
import com.mongodb.domain.entity.Fitness
import com.mongodb.kotlin.client.coroutine.MongoDatabase
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.toList
import org.bson.types.ObjectId


class FitnessRepositoryImpl(private val mongoDatabase: MongoDatabase) : FitnessRepository {

    companion object {
        const val FITNESS_COLLECTION = "fitness"
    }

    override suspend fun findAll(): List<Fitness> {
        return mongoDatabase.getCollection<Fitness>(FITNESS_COLLECTION).find().toList()
    }

    override suspend fun findById(objectId: ObjectId): Fitness? =
        mongoDatabase.getCollection<Fitness>(FITNESS_COLLECTION).withDocumentClass<Fitness>()
            .find(eq("_id", objectId))
            .firstOrNull()

    override suspend fun findByExerciseType(type: String): List<Fitness> =
        mongoDatabase.getCollection<Fitness>(FITNESS_COLLECTION).withDocumentClass<Fitness>()
            .find(eq(Fitness::exerciseType.name, type))
            .toList()


}