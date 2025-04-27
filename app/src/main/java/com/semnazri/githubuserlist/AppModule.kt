package com.semnazri.githubuserlist

import com.semnazri.githubuserlist.data.feature.UserListRepository
import com.semnazri.githubuserlist.data.feature.UserListViewModel
import com.semnazri.githubuserlist.remote.NetworkClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { NetworkClient() }
    single { UserListRepository(get()) }
    viewModel { UserListViewModel(get()) }
}