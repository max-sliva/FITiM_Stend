package com.example.plugins

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import java.io.File

fun Application.configureRouting() {

    routing {
        static {
            files("Stend")
            default("Stend/index.html")
        }
        get("/") {
            call.respondFile(File("Stend/index.html"))
        }
    }
}
