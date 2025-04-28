package com.semnazri.githubuserlist

import com.semnazri.githubuserlist.data.feature.userdetail.DetailUserRepository
import com.semnazri.githubuserlist.data.feature.userdetail.DetailUserViewModel
import com.semnazri.githubuserlist.data.feature.userlist.UserListRepository
import com.semnazri.githubuserlist.data.feature.userlist.UserListViewModel
import com.semnazri.githubuserlist.remote.NetworkClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val networkModule = module {
    single { NetworkClient() }
}


val repositoryModule = module {
    single { UserListRepository(get()) }
    single { DetailUserRepository(get()) }
}

val viewModelModule = module {
    viewModel { UserListViewModel(get()) }
    viewModel { DetailUserViewModel(get()) }
}