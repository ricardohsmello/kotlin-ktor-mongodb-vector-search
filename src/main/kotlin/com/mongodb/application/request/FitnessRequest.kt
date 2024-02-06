package com.mongodb.application.request

import com.mongodb.domain.entity.Fitness
import com.mongodb.domain.entity.FitnessDetails
import org.bson.types.ObjectId
import java.util.*
data class FitnessRequest(
    val exerciseType: String,
    val startTime: Date?,
    val endTime: Date?,
    val notes: String?,
    val details: FitnessDetails?
)
fun FitnessRequest.toDomain(): Fitness {
    return Fitness(
        id = ObjectId(),
        exerciseType = exerciseType,
        startTime = startTime ?: Date(),
        endTime = endTime,
        notes = notes,
        details = details
    )
}
