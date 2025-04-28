package com.semnazri.githubuserlist.data.feature.userlist

import com.semnazri.githubuserlist.data.model.userlist.UserList
import com.semnazri.githubuserlist.data.model.usersearch.UserSearch
import com.semnazri.githubuserlist.remote.NetworkClient
import com.semnazri.githubuserlist.remote.UserEndpoints

class UserListRepository(private val networkClient: NetworkClient) {

    suspend fun fetchUsers(): ArrayList<UserList> {
        return networkClient.get(
            endpoint = UserEndpoints.GetAllUsers
        )
    }

    suspend fun searchUser(query: String): UserSearch {
        val queryParams = mapOf("q" to query)
        return NetworkClient().get(endpoint = UserEndpoints.SearchUser, queryParams = queryParams)
    }
}