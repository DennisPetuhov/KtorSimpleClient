package com.example.ktorsimpleclient

import com.example.ktorsimpleclient.models.MyMessage
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.plugins.websocket.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.KotlinxWebsocketSerializationConverter
import io.ktor.websocket.*
import kotlinx.coroutines.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.util.*

fun simpleSocket() {
    val client = HttpClient(CIO) {
        install(WebSockets) {
            contentConverter = KotlinxWebsocketSerializationConverter(Json {
                isLenient = true; ignoreUnknownKeys = true
            })
            this.pingIntervalMillis = 20_000

        }
        install(Logging) {
            logger = Logger.SIMPLE
            level = LogLevel.ALL
        }
    }
    runBlocking {
        client.webSocket(
            method = HttpMethod.Get,
            host = "localhost",
            port = 8080,
            path = "/websocet/1"
        ) {
            while (true) {
                val othersMessage = incoming.receive() as? Frame.Text
                println(othersMessage?.readText())
                val myMessage = Scanner(System.`in`).next()
                if (myMessage != null) {
                    send(myMessage)
                }
            }
        }
    }
    client.close()
}

fun simpleSocket2() = runBlocking {
    val client = HttpClient(CIO) {
        install(WebSockets) {
            contentConverter = KotlinxWebsocketSerializationConverter(Json {
                isLenient = true; ignoreUnknownKeys = true
            })
            this.pingIntervalMillis = 20_000

        }
    }

    client.ws(
        method = HttpMethod.Get,
        host = "localhost",
        port = 8080,
        path = "/websocket"
    ) {
        val message = MyMessage("Hello, WebSocket!")
        val jsonMessage = Json.encodeToString(message)
        send(Frame.Text(jsonMessage))
    }

    client.close()
}