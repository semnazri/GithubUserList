package com.semnazri.githubuserlist.ui.navigation

sealed class Screens(val route: String) {
    object Main : Screens("main")
    object Detail : Screens("detail/{username}") {
        fun createRoute(username: String) = "detail/$username"
    }
}