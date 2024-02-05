package com.mongodb

import com.mongodb.infrastructure.modules.fitnessModule
import com.mongodb.infrastructure.modules.mongoModule
import com.mongodb.infrastructure.plugins.configureRouting
import com.mongodb.infrastructure.plugins.configureSerialization
import io.ktor.server.application.*
import io.ktor.server.tomcat.*
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module() {

    install(Koin) {
        slf4jLogger()
        modules(mongoModule, fitnessModule)
    }

    configureSerialization()
    configureRouting()
}

