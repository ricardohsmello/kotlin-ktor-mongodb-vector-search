package com.mongodb.application.routes

import com.mongodb.application.request.SentenceRequest
import com.mongodb.domain.ports.ExercisesRepository
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.exercisesRoutes() {
    val repository by inject<ExercisesRepository>()

    route("/exercises/processRequest") {
        post {
            val sentence = call.receive<SentenceRequest>()

            val response = requestSentenceTransform(sentence.input)

            if (response.status.isSuccess()) {
                val embedding = sentence.convertResponse(response.body())
                val similarDocuments = repository.findSimilarDocuments(embedding)

                call.respond(HttpStatusCode.Accepted, similarDocuments.map { it.toResponse() })
            }
        }
    }
}

suspend fun requestSentenceTransform(input: String): HttpResponse {
    return HttpClient(CIO).use { client ->
        val response =
            client.post("https://api-inference.huggingface.co/pipeline/feature-extraction/sentence-transformers/all-MiniLM-L6-v2") {
                val content = TextContent(input, ContentType.Text.Plain)
                setBody(content)
            }
        response
    }
}
