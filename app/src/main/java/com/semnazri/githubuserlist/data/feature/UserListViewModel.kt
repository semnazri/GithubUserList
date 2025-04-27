package com.semnazri.githubuserlist.data.feature

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserListViewModel(private val repository: UserListRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<UserListState>(UserListState.Loading)
    val uiState: StateFlow<UserListState> = _uiState

    fun onEvent(event: UserListEvent) {
        when (event) {
            is UserListEvent.LoadData -> loadUsers()
            is UserListEvent.Retry -> loadUsers()
            is UserListEvent.OnUserClick -> {
                Log.d("UserListViewModel", "User clicked: ${event.userId}")
            }
        }
    }

    private fun loadUsers() {
        viewModelScope.launch {
            _uiState.value = UserListState.Loading
            try {
                val users = repository.fetchUsers()
                _uiState.value = UserListState.Success(users)
            } catch (e: Exception) {
                _uiState.value = UserListState.Error(e.message ?: "Unknown error")
            }
        }
    }
}