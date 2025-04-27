package com.semnazri.githubuserlist.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(
    @SerialName("documentation_url")
    val documentationUrl: String,
    @SerialName("message")
    val message: String,
    @SerialName("status")
    val status: String
)