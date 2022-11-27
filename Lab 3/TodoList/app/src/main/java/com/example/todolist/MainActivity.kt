package com.example.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.todolist.model.TodoViewModel
import com.example.todolist.ui.compose.TodoScreen
import com.example.todolist.ui.theme.TodoListTheme
import com.example.todolist.ui.theme.TodoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ScreenSetup()
                }
            }
        }
    }
}


@Composable
fun ScreenSetup(viewModel: TodoViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    TodoScreen(viewModel.todoList, {viewModel.add(it)}, {viewModel.delete(it)})
}