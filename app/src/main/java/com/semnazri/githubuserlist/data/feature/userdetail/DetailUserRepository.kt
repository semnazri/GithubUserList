package com.semnazri.githubuserlist.data.feature.userdetail

import com.semnazri.githubuserlist.data.model.userdetail.UserDetail
import com.semnazri.githubuserlist.data.model.userrepo.UserRepositoryItem
import com.semnazri.githubuserlist.remote.NetworkClient
import com.semnazri.githubuserlist.remote.UserEndpoints

class DetailUserRepository(private val networkClient: NetworkClient) {
    suspend fun getUser(username: String): UserDetail {
        return networkClient.get(endpoint = UserEndpoints.GetDetailUser(username))
    }

    suspend fun getUserRepos(username: String): List<UserRepositoryItem> {
        return networkClient.get(endpoint = UserEndpoints.GetDetailRepoUser(username))
    }
}