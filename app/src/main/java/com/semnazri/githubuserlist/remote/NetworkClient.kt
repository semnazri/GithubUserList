package com.semnazri.githubuserlist.remote

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import okhttp3.logging.HttpLoggingInterceptor

object HttpClientProvider {

    private val commonHeaders = mapOf(
        "Accept" to "application/vnd.github+json",
        "Authorization" to "Bearer <YOUR TOKEN HERE>",
    )

    val client: HttpClient by lazy {
        HttpClient(OkHttp) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                    isLenient = true
                })
            }

            engine {
                addInterceptor(
                    HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    }
                )
            }

            install(DefaultRequest) {
                commonHeaders.forEach { (key, value) ->
                    header(key, value)
                }
            }
        }
    }
}