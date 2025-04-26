package com.semnazri.githubuserlist.data.model.usersearch


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserSearch(
    @SerialName("incomplete_results")
    val incompleteResults: Boolean,
    @SerialName("items")
    val items: List<Item>,
    @SerialName("total_count")
    val totalCount: Int
)