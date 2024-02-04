package com.mongodb.application.routes

import io.ktor.server.plugins.openapi.*
import io.ktor.server.plugins.swagger.*
import io.ktor.server.routing.*
import io.swagger.codegen.v3.generators.html.StaticHtmlCodegen

fun Route.swaggerRouting() {

    swaggerUI(path = "swagger", swaggerFile = "openapi/documentation.yaml") {
        version = "4.15.5"
    }
    openAPI(path="openapi", swaggerFile = "openapi/documentation.yaml") {
        codegen = StaticHtmlCodegen()
    }
}