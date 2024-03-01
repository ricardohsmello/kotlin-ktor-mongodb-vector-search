package com.mongodb.domain.ports

import com.mongodb.domain.entity.Exercises

interface ExercisesRepository {
    suspend fun findSimilarDocuments(embedding: List<Double>): List<Exercises>
}