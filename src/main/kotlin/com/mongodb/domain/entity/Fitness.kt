package com.mongodb.domain.entity
import com.mongodb.application.response.FitnessResponse
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.util.*
data class Fitness(
    @BsonId
    val id: ObjectId,
    val exerciseType: String,
    val startTime: Date,
    val endTime: Date?,
    val notes: String?,
    val details: FitnessDetails?
) {
    fun toResponse() = FitnessResponse(
            id = id.toString(),
            exerciseType = exerciseType,
            startTime = startTime,
            endTime = endTime,
            notes = notes,
            details = details
        )
    }
data class FitnessDetails(
    val durationMinutes: Int,
    val distance: Double,
    val caloriesBurned: Int
)
