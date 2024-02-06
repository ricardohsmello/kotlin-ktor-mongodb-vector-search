package com.mongodb.application.routes

import io.ktor.server.plugins.swagger.*
import io.ktor.server.routing.Route

fun Route.swaggerRoute() {

    swaggerUI(path = "openapi", swaggerFile = "openapi/documentation.yaml") {
        version = "4.15.5"
    }

}