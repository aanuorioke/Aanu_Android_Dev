package com.example.bottomnavigationproject.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings

val sampleNavigationItemData = listOf<NavigationItem>(
    NavigationItem(
        description = "Notifications",
        route = "notifications",
        icon = Icons.Filled.Notifications
    ),
    NavigationItem(
        description = "Settings",
        route = "settings",
        icon = Icons.Filled.Settings
    ),
    NavigationItem(
        description = "Account",
        route = "account",
        icon = Icons.Filled.AccountCircle
    )
)