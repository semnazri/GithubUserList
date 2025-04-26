package com.semnazri.githubuserlist.data.remote

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

    object GetDetailUser {
        fun userName(name : String)  = "/search/users/$name"
    }

    object GetDetailRepoUser {
        fun userName(name : String)  = "/search/users/$name/repos"
    }
}