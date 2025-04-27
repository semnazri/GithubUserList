package com.semnazri.githubuserlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.semnazri.githubuserlist.data.model.userlist.UserList
import com.semnazri.githubuserlist.remote.NetworkClient
import com.semnazri.githubuserlist.remote.UserEndpoints
import com.semnazri.githubuserlist.ui.navigation.AppNavigation
import com.semnazri.githubuserlist.ui.navigation.Screens
import com.semnazri.githubuserlist.ui.screens.MainScreen
import com.semnazri.githubuserlist.ui.theme.GithubUserListTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            enableEdgeToEdge()
            setContent {
                GithubUserListTheme {
                    AppNavigation()
                }
            }

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GithubUserListTheme {
    }
}