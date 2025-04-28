package com.semnazri.githubuserlist.data.model.userrepo


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserRepositoryItem(

    @SerialName("description")
    val description: String? = "",

    @SerialName("fork")
    val fork: Boolean = false,

    @SerialName("forks")
    val forks: Int = 0,

    @SerialName("forks_count")
    val forksCount: Int = 0,

    @SerialName("html_url")
    val html_url: String? = "",

    @SerialName("language")
    val language: String? = "",

    @SerialName("name")
    val name: String = "",

    @SerialName("stargazers_count")
    val stargazersCount: Int = 0
)