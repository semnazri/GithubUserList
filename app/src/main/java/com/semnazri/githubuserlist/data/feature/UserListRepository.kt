package com.semnazri.githubuserlist.data.feature

import com.semnazri.githubuserlist.data.model.userlist.UserList
import com.semnazri.githubuserlist.remote.NetworkClient
import com.semnazri.githubuserlist.remote.UserEndpoints

class UserListRepository(private val networkClient: NetworkClient) {

    suspend fun fetchUsers(): ArrayList<UserList> {
        return networkClient.get(
            endpoint = UserEndpoints.GetAllUsers
        )
    }
}