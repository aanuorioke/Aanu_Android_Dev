package com.example.bottomnavigationproject.model

sealed class Routes(val route: String) {
    object Notifications : Routes("notifications")
    object Settings : Routes("settings")
    object Account : Routes("account")
}
