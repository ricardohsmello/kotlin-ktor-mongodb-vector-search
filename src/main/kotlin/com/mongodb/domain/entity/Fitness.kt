package com.mongodb.domain.entity
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.util.*

data class Fitness(
    @BsonId
    val id: ObjectId,
    val exerciseType: String,
    val startTime: Date,
    val endTime: Date,
    val notes: String,
    val details: FitnessDetails
)

data class FitnessDetails(
    val durationMinutes: Int,
    val distance: Double,
    val caloriesBurned: Int
)
