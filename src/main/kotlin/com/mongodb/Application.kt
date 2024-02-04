package com.mongodb

import com.mongodb.plugins.configureRouting
import com.mongodb.plugins.configureSerialization
import io.ktor.server.application.*
import io.ktor.server.tomcat.*

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module() {
    configureSerialization()
    configureRouting()
}
