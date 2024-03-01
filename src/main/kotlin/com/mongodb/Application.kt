package com.mongodb

import com.mongodb.application.routes.exercisesRoutes
import com.mongodb.application.routes.fitnessRoutes
import com.mongodb.domain.ports.ExercisesRepository
import com.mongodb.domain.ports.FitnessRepository
import com.mongodb.infrastructure.ExercisesRepositoryImpl
import com.mongodb.infrastructure.FitnessRepositoryImpl
import com.mongodb.kotlin.client.coroutine.MongoClient
import io.ktor.serialization.gson.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.swagger.*
import io.ktor.server.routing.*
import io.ktor.server.tomcat.*
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun main(args: Array<String>): Unit = EngineMain.main(args)
fun Application.module() {

    install(ContentNegotiation) {
        gson {
        }
    }

    install(Koin) {
        slf4jLogger()
        modules(module {
            val mongoUri =
                environment.config.propertyOrNull("ktor.mongo.uri")?.getString() ?: throw RuntimeException("Failed to access MongoDB URI.")
            val databaseName = environment.config.property("ktor.mongo.database").getString()

            single { MongoClient.create(mongoUri) }
            single { get<MongoClient>().getDatabase(databaseName) }
        }, module {
            single<FitnessRepository> { FitnessRepositoryImpl(get()) }
            single<ExercisesRepository> { ExercisesRepositoryImpl(get()) }
        })
    }

    routing {
        swaggerUI(path = "swagger-ui", swaggerFile = "openapi/documentation.yaml") {
            version = "4.15.5"
        }
        fitnessRoutes()
        exercisesRoutes()
    }
}

