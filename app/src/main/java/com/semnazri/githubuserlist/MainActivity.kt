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
import com.semnazri.githubuserlist.data.remote.NetworkClient
import com.semnazri.githubuserlist.data.remote.UserEndpoints
import com.semnazri.githubuserlist.ui.navigation.Screens
import com.semnazri.githubuserlist.ui.theme.GithubUserListTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val networkClient = NetworkClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CoroutineScope(Dispatchers.Main).launch {
            try {
                // Memanggil fungsi get dengan Endpoint SearchUser dan query param
                val response: List<UserList> = networkClient.get(
                    endpoint = UserEndpoints.GetAllUsers
                )

                // Tampilkan hasil response
                println("Total users: ${response.size}")
                println("Users: ${response[0].login}")

                // Misalnya, update UI dengan hasilnya
                // updateRecyclerView(response.items)

            } catch (e: Exception) {
                // Handle error
                e.printStackTrace()
            }
        }
            enableEdgeToEdge()
            setContent {
                GithubUserListTheme {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screens.Main.route
                    ) {
                        composable(route = Screens.Main.route) {
                            // TODO: Replace with real state + logic
                        }
                    }
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