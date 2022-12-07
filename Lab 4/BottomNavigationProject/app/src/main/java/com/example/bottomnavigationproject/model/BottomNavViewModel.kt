package com.example.bottomnavigationproject.model

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class BottomNavViewModel: ViewModel() {
    var bottomNavigationItems = mutableStateListOf<NavigationItem>()

    fun add(newNavigationItem: NavigationItem) {
        bottomNavigationItems.add(newNavigationItem)
    }

    fun delete(navigationItem: NavigationItem) {
        bottomNavigationItems.remove(navigationItem)
    }
}