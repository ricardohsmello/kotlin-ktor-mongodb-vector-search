package com.mongodb.plugins

import com.mongodb.application.routes.fitnessRouting
import com.mongodb.application.routes.swaggerRouting
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    routing {
        swaggerRouting()
        fitnessRouting()
    }

}
