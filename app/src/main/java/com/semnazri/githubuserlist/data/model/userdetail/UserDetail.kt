package com.semnazri.githubuserlist.data.model.userdetail


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDetail(
    @SerialName("avatar_url")
    val avatarUrl: String,
    @SerialName("followers")
    val followers: Int,
    @SerialName("following")
    val following: Int,
    @SerialName("login")
    val login: String,
    @SerialName("name")
    val name: String,
)