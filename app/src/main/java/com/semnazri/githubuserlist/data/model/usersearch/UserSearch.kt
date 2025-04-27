package com.semnazri.githubuserlist.data.model.usersearch


import com.semnazri.githubuserlist.data.model.userlist.UserList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserSearch(
    @SerialName("incomplete_results")
    val incompleteResults: Boolean,
    @SerialName("items")
    val items: List<UserList>,
    @SerialName("total_count")
    val totalCount: Int
)