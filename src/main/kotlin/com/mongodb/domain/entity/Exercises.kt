package com.mongodb.domain.entity

import com.mongodb.application.response.ExercisesResponse
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class Exercises(
    @BsonId
    val id: ObjectId,
    val exerciseNumber: Int,
    val title: String,
    val desc: String,
    val type: String,
    val bodyPart: String,
    val equipment: String,
    val level: String,
    val rating: String,
    val ratingDesc: String,
    val titleEmbedding: List<Double>
){
    fun toResponse() = ExercisesResponse(
        exerciseNumber = exerciseNumber,
        title = title,
        desc = desc,
        bodyPart = bodyPart,
        type = type
    )
}
