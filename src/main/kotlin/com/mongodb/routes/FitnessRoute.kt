package com.mongodb.routes

import com.mongodb.FitnessService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.*
import org.koin.ktor.ext.inject

fun Route.fitnessRouting() {
    val service by inject<FitnessService>()


    route("/fitness") {
        get {

            call.respond(service.findAll().map { it })
        }
        get("{id?}") {
            val id = call.parameters["id"] ?: return@get call.respondText(
                "Missing id",
                status = HttpStatusCode.BadRequest
            )

          call.respond(service.findById(id))
        }
        post {

        }
        delete("{id?") {

        }
    }
}