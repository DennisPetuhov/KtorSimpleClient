package com.example.ktorsimpleclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.ktorsimpleclient.models.AssResponse
import com.example.ktorsimpleclient.ui.theme.KtorSimpleClientTheme
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KtorSimpleClientTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        onclick = { onclick() },
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalSerializationApi::class)
fun onclick() {
    println("Button clicked")
    runBlocking {
        val client = HttpClient(CIO) {

            install(ContentNegotiation) {
                json(Json {
                    encodeDefaults = true
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                    explicitNulls = false
                })
            }
        }
        val response = client.get("https://avalanche.ge/json")
        if (response.contentType() == ContentType.Application.Json) {
            val responseBody = response.body<AssResponse>()
            println("ContentType.Application.Json   BODY = $responseBody")
        } else {
            println("Unexpected content type: ${response.contentType()}")
            val responseBody = response.body<String>()
            val responseHeader = response.headers.toString()
            println("Response header: $responseHeader")
            println("Response body: $responseBody")
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, onclick: () -> Unit) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Button(onClick = { onclick() }) {}
    }
}
