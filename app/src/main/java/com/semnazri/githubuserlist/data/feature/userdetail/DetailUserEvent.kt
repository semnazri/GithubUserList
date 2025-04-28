package com.semnazri.githubuserlist.data.feature.userdetail

sealed class DetailUserEvent {
    data class LoadDetailUser(val username: String) : DetailUserEvent()
    data class RetryDetailUser(val username: String) : DetailUserEvent()
    data class LoadRepositoryUser(val username: String) : DetailUserEvent()
    data class RetryRepositoryUser(val username: String) : DetailUserEvent()
    data class OnRepositoryClick(val link: String) : DetailUserEvent()
}