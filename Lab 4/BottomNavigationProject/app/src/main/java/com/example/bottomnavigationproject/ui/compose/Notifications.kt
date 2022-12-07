package com.example.bottomnavigationproject.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bottomnavigationproject.model.Routes

@Composable
fun Notifications(){
    Column(Modifier.padding(20.dp)) {
        Text(text = "You do not have any Notifications")
    }
}