package com.semnazri.githubuserlist.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.semnazri.core_ui.molecules.MyErrorComponent
import com.semnazri.core_ui.molecules.MyLoading
import com.semnazri.core_ui.molecules.MySearchBar
import com.semnazri.core_ui.molecules.MyUserCardItem
import com.semnazri.githubuserlist.data.feature.userlist.UserListEvent
import com.semnazri.githubuserlist.data.feature.userlist.UserListState
import com.semnazri.githubuserlist.data.feature.userlist.UserListViewModel
import com.semnazri.githubuserlist.data.model.userlist.UserList
import com.semnazri.githubuserlist.ui.navigation.Screens
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(navController: NavController) {
    val viewModel: UserListViewModel = koinViewModel()
    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value
    val searchQuery = viewModel.searchQuery.collectAsStateWithLifecycle().value

    LaunchedEffect(Unit) {
        viewModel.onEvent(UserListEvent.LoadData)
    }

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            MySearchBar(
                hint = "Search User",
                initialValue = searchQuery,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                onSearch = {
                    viewModel.onEvent(UserListEvent.Search(it))
                },
                onClear = {
                    viewModel.onEvent(UserListEvent.ClearSearch)
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp)
            ) {
                when (uiState) {
                    is UserListState.Loading -> {
                        MyLoading()
                    }

                    is UserListState.Success -> {
                        UserListContent(
                            users = uiState.users,
                            onUserClick = { userId ->
                                navController.navigate(Screens.Detail.createRoute(userId))
                            }
                        )
                    }

                    is UserListState.Error -> {
                        MyErrorComponent(
                            message = uiState.message,
                            onRetry = {
                                viewModel.onEvent(UserListEvent.Retry)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun UserListContent(
    users: List<UserList>,
    onUserClick: (String) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(users) { user ->
            MyUserCardItem(
                onClick = {onUserClick(user.login)},
                username = user.login,
                avatarUrl = user.avatarUrl,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


