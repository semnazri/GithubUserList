package com.semnazri.githubuserlist.data.feature.userlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.semnazri.githubuserlist.data.model.userlist.UserList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UserListViewModel(private val repository: UserListRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<UserListState>(UserListState.Loading)
    val uiState: StateFlow<UserListState> = _uiState
    private var originalUsers: List<UserList> = emptyList()
    private var isFirstLoad = true
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    fun onEvent(event: UserListEvent) {
        when (event) {
            is UserListEvent.LoadData -> loadUsers()
            is UserListEvent.Retry -> loadUsers()
            is UserListEvent.ClearSearch -> clearSearch()
            is UserListEvent.Search ->{
                _searchQuery.value = event.query
                searchUsers(event.query)
            }
        }
    }

    private fun loadUsers() {
        if (!isFirstLoad)
            return

        viewModelScope.launch {
            _uiState.value = UserListState.Loading
            try {
                val users = repository.fetchUsers()
                originalUsers = users
                _uiState.value = UserListState.Success(users)
            } catch (e: Exception) {
                _uiState.value = UserListState.Error(e.message ?: "Unknown error")
            }
        }

        isFirstLoad = false
    }

    private fun searchUsers(query: String) {
        viewModelScope.launch {
            _uiState.value = UserListState.Loading
            try {
                val searchResults = repository.searchUser(query)
                _uiState.value = UserListState.Success(searchResults.items)
            } catch (e: Exception) {
                _uiState.value = UserListState.Error(e.message ?: "Failed to search users")
            }
        }
    }

    private fun clearSearch() {
        _uiState.update { currentState ->
            if (currentState is UserListState.Success) {
                _searchQuery.value = ""
                UserListState.Success(originalUsers)
            } else {
                currentState
            }
        }
    }
}