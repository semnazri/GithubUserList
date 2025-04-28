package com.semnazri.githubuserlist.data.feature.userdetail

import com.semnazri.githubuserlist.data.model.userdetail.UserDetail
import com.semnazri.githubuserlist.data.model.userrepo.UserRepositoryItem

sealed class DetailUserState {
    object DetailLoading : DetailUserState()
    data class DetailSuccess(val user: UserDetail) : DetailUserState()
    data class DetailError(val message: String) : DetailUserState()

}

sealed class RepoUserState {
    object RepoLoading : RepoUserState()
    data class RepoSuccess(val repos: List<UserRepositoryItem>) : RepoUserState()
    data class RepoError(val message: String) : RepoUserState()
}