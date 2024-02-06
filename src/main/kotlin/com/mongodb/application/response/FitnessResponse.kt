package com.mongodb.application.response

import com.mongodb.domain.entity.FitnessDetails
import java.util.*
data class FitnessResponse(
    val id: String,
    val exerciseType: String,
    val startTime: Date?,
    val endTime: Date?,
    val notes: String?,
    val details: FitnessDetails?
)