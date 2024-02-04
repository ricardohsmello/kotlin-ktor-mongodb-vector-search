package com.mongodb

import com.mongodb.plugins.configureRouting
import com.mongodb.plugins.configureSerialization
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

