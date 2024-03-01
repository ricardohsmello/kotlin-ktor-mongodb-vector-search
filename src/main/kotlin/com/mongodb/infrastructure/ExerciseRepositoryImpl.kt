package com.mongodb.infrastructure

import com.mongodb.domain.entity.Exercises
import com.mongodb.domain.ports.ExercisesRepository
import com.mongodb.kotlin.client.coroutine.MongoDatabase
import kotlinx.coroutines.flow.toList
import org.bson.Document

class ExercisesRepositoryImpl(
    private val mongoDatabase: MongoDatabase
) : ExercisesRepository {

    companion object {
        const val EXERCISES_COLLECTION = "exercises"
    }

   override suspend fun findSimilarDocuments(embedding: List<Double>): List<Exercises> {
        val result =
            mongoDatabase.getCollection<Exercises>(EXERCISES_COLLECTION).withDocumentClass<Exercises>().aggregate(
                listOf(
                    Document(
                        "\$vectorSearch",
                        Document("queryVector", embedding)
                            .append("path", "titleEmbedding")
                            .append("numCandidates", 5L)
                            .append("index", "vector_index")
                            .append("limit", 5L)
                    )
                )
            )

        return result.toList()
    }
}

