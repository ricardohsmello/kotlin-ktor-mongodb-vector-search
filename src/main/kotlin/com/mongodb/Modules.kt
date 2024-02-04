package com.mongodb

import com.mongodb.domain.service.FitnessService
import com.mongodb.infrastructure.repository.FitnessRepository
import com.mongodb.infrastructure.repository.FitnessRepositoryImpl
import com.mongodb.kotlin.client.coroutine.MongoClient
import com.typesafe.config.ConfigFactory
import io.ktor.server.config.*
import org.koin.dsl.module

private val config = HoconApplicationConfig(ConfigFactory.load())
private val mongoUri = config.property("ktor.mongo.uri").getString()
private val databaseName = config.propertyOrNull("ktor.mongo.database")?.getString()
    ?: throw RuntimeException("Database must not be null!")

val mongoModule = module {
    single { MongoClient.create(mongoUri) }
    single { get<MongoClient>().getDatabase(databaseName) }
}

val fitnessModule = module {
    single<FitnessRepository> { FitnessRepositoryImpl(get()) }
    single { FitnessService(get()) }
}
