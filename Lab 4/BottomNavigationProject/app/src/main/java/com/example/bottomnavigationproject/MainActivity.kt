package com.example.bottomnavigationproject

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bottomnavigationproject.model.BottomNavViewModel
import com.example.bottomnavigationproject.ui.compose.BottomBar
import com.example.bottomnavigationproject.ui.compose.BottomNavBar
import com.example.bottomnavigationproject.ui.theme.BottomNavigationProjectTheme
import com.example.bottomnavigationproject.ui.theme.NavTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavTheme {
                    Screen()
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun Screen() {

    BottomNavBar()
}

@RequiresApi(Build.VERSION_CODES.N)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val viewModel: BottomNavViewModel = viewModel();
    BottomNavigationProjectTheme {
        Screen()
    }
}