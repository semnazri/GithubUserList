package com.semnazri.githubuserlist.ui.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.semnazri.core_ui.molecules.MyErrorComponent
import com.semnazri.core_ui.molecules.MyLoading
import com.semnazri.core_ui.molecules.MyProfileHeader
import com.semnazri.core_ui.molecules.MyRepositoryItem
import com.semnazri.githubuserlist.data.feature.userdetail.DetailUserEvent
import com.semnazri.githubuserlist.data.feature.userdetail.DetailUserState
import com.semnazri.githubuserlist.data.feature.userdetail.DetailUserViewModel
import com.semnazri.githubuserlist.data.feature.userdetail.RepoUserState
import com.semnazri.githubuserlist.openUrl
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailScreen(userId: String) {
    val viewModel: DetailUserViewModel = koinViewModel()
    val userState = viewModel.uiState.collectAsStateWithLifecycle().value
    val repoState = viewModel.repoState.collectAsStateWithLifecycle().value
    val context = LocalContext.current

    LaunchedEffect(userId) {
        viewModel.onEvent(DetailUserEvent.LoadDetailUser(userId))
        viewModel.onEvent(DetailUserEvent.LoadRepositoryUser(userId))
    }

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            when (userState) {
                is DetailUserState.DetailLoading -> MyLoading()
                is DetailUserState.DetailError -> {
                    MyErrorComponent(
                        message = userState.message,
                        onRetry = {
                            viewModel.onEvent(DetailUserEvent.RetryDetailUser(userId))
                        }
                    )
                }

                is DetailUserState.DetailSuccess -> {
                    userState.user.let { user ->
                        MyProfileHeader(
                            avatarUrl = user.avatarUrl,
                            username = user.login,
                            name = user.name,
                            followers = user.followers,
                            following = user.following
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            when (repoState) {
                is RepoUserState.RepoLoading -> MyLoading()
                is RepoUserState.RepoError -> {
                    MyErrorComponent(
                        message = repoState.message,
                        onRetry = {
                            viewModel.onEvent(DetailUserEvent.RetryRepositoryUser(userId))
                        }
                    )
                }

                is RepoUserState.RepoSuccess -> {
                    LazyColumn(
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(repoState.repos) { repo ->
                            MyRepositoryItem(
                                repoName = repo.name,
                                language = repo.language ?: "N/A",
                                stars = repo.stargazersCount,
                                description = repo.description ?: "No description",
                                onClick = {
                                    val url = repo.html_url
                                    openUrl(context = context, url = url.toString())
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}