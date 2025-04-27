package com.semnazri.githubuserlist.data.feature

import com.semnazri.githubuserlist.data.model.userlist.UserList

sealed class UserListState {
    object Loading : UserListState()
    data class Success(val users: ArrayList<UserList>) : UserListState()
    data class Error(val message: String) : UserListState()
}