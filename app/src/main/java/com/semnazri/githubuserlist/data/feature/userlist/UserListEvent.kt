package com.semnazri.githubuserlist.data.feature.userlist

sealed class UserListEvent {
    object LoadData : UserListEvent()
    object Retry : UserListEvent()
    object ClearSearch : UserListEvent()
    data class Search(val query: String) : UserListEvent()

}