package com.mongodb.plugins

import com.mongodb.routes.fitnessRouting
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {


    routing {
        fitnessRouting()
    }


}
