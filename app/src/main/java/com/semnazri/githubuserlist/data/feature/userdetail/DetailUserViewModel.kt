package com.semnazri.githubuserlist.data.feature.userdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class DetailUserViewModel(private val detailRepository: DetailUserRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<DetailUserState>(DetailUserState.DetailLoading)
    val uiState: StateFlow<DetailUserState> = _uiState

    private val _repoState = MutableStateFlow<RepoUserState>(RepoUserState.RepoLoading)
    val repoState: StateFlow<RepoUserState> = _repoState

    fun onEvent(event: DetailUserEvent) {
        when (event) {
            is DetailUserEvent.LoadDetailUser -> loadUserDetail(event.username)
            is DetailUserEvent.RetryDetailUser -> loadUserDetail(event.username)
            is DetailUserEvent.LoadRepositoryUser -> loadUserRepositories(event.username)
            is DetailUserEvent.RetryRepositoryUser -> loadUserRepositories(event.username)
            is DetailUserEvent.OnRepositoryClick -> handleRepositoryClick(event.link)
        }
    }

    private fun loadUserDetail(username: String) {
        viewModelScope.launch {
            _uiState.value = DetailUserState.DetailLoading
            try {
                val user = detailRepository.getUser(username)
                _uiState.value = DetailUserState.DetailSuccess(user)
            } catch (e: Exception) {
                _uiState.value = DetailUserState.DetailError(e.message ?: "Unknown error")
            }
        }
    }

    private fun loadUserRepositories(username: String) {
        viewModelScope.launch {
            _repoState.value = RepoUserState.RepoLoading
            try {
                val repos = detailRepository.getUserRepos(username)
                val nonForkedRepos = repos.filterNot { it.fork }
                _repoState.value = RepoUserState.RepoSuccess(nonForkedRepos)
            } catch (e: Exception) {
                _repoState.value = RepoUserState.RepoError(e.message ?: "Unknown error")
            }
        }
    }

    private fun handleRepositoryClick(link: String) {
        // Handle repository click, e.g., open URL in a browser or WebView
        // This depends on your app's requirements and UI implementation.
    }

}