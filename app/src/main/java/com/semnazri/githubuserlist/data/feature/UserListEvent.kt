package com.semnazri.githubuserlist.data.feature

sealed class UserListEvent {
    object LoadData : UserListEvent()
    object Retry : UserListEvent()
    data class OnUserClick(val userId: String) : UserListEvent()
    object ClearSearch : UserListEvent()
    data class Search(val query: String) : UserListEvent()

}