package com.mongodb

import com.mongodb.kotlin.client.coroutine.MongoClient
import com.mongodb.kotlin.client.coroutine.MongoCollection
import kotlinx.coroutines.flow.first
import org.bson.Document
import org.koin.dsl.module
import org.koin.java.KoinJavaComponent.get
import org.koin.java.KoinJavaComponent.inject

class FitnessService(private val collections: MongoCollection<Document>) {

    fun findAll(): List<String> = listOf("123")
//        articleCollection.find()
//            .toList()

    suspend fun findById(id: String): Document {
        return collections.find(Document("_id", id)).first()
    }
}


