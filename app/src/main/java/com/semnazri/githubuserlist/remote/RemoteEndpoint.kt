package com.semnazri.githubuserlist.remote

interface Endpoint {
    val path: String
}

object UserEndpoints {
    object GetAllUsers : Endpoint {
        override val path = "/users"
    }

    object SearchUser : Endpoint{
        override val path = "/search/users"
    }

    data class GetDetailUser(val username: String) : Endpoint {
        override val path: String
            get() = "/users/$username"
    }

    data class GetDetailRepoUser(val username: String) : Endpoint {
        override val path: String
            get() = "/users/$username/repos"
    }
}