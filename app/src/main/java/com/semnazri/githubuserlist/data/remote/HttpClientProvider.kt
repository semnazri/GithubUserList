package com.semnazri.githubuserlist.data.remote

import com.semnazri.githubuserlist.BuildConfig
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url

class NetworkClient(val client: HttpClient = HttpClientProvider.client) {

    suspend inline fun <reified T> get(
        endpoint: Endpoint,
        queryParams: Map<String, String>? = null
    ): T {
        val baseUrl = BuildConfig.BASE_URL
        val url = "$baseUrl${endpoint.path}"

        return client.get {
            url(url)
            queryParams?.forEach { (key, value) ->
                parameter(key, value)
            }
        }.body()
    }
}