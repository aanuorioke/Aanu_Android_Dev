package com.example.todolist.ui.compose

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todolist.model.Todo
import com.example.todolist.model.TodoViewModel
import com.example.todolist.R


@Composable
fun TodoScreen(todoList:List<Todo>, addTodoItem: (Todo) -> Unit, deleteTodoItem: (Todo) -> Unit) {
    val viewModel: TodoViewModel = viewModel();
    var showDialog by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {showDialog=true}) {
                Icon(Icons.Filled.Add, contentDescription = "")
            }
        },
        content = {
            if (showDialog){
                addBookDialog(context, dismissDialog = {showDialog = false}, {viewModel.add(it)})
            }
            LazyColumn(
                contentPadding = PaddingValues(
                    vertical = 8.dp,
                    horizontal = 8.dp
                ),
                modifier = Modifier
                    .padding(8.dp)

            ) {
                items(viewModel.todoList, key = {todo -> todo.id }) { todo ->
                    TodoItem(item = todo, context, {viewModel.delete(it)})
                }
            }

        })
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TodoItem (item: Todo, context: Context, deleteTodo: (Todo)->Unit)
{
    var showDeleteDialog by remember { mutableStateOf(false) }
    var done by remember { mutableStateOf(false) }

    
    Card(
        elevation = 14.dp,
        shape = RoundedCornerShape(10.dp),
        backgroundColor = changeCardColorWhenCompleted(done = done),
        contentColor = changeContentColorWhenCompleted(done = done),
        border = BorderStroke(2.dp, color = MaterialTheme.colors.primaryVariant),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .combinedClickable(
                onClick = {
                    Toast
                        .makeText(
                            context,
                            context.resources.getString(R.string.readmsg) + " " + item.title,
                            Toast.LENGTH_LONG
                        )
                        .show()
                },
                onLongClick = { showDeleteDialog = true }
            )

    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Row() {
                Column() {
                    Checkbox(checked = done, onCheckedChange = {done = !done})
                }
                Column() {
                    Text(text = item.title, style = MaterialTheme.typography.h6)
                    Text(text = item.content, style = MaterialTheme.typography.body1)
                    Text(text = item.author, style = MaterialTheme.typography.body1)


                }
            }

        }
    }
    if (showDeleteDialog){
        deleteBookDialog(context, dismissDialog = {showDeleteDialog = false}, item, deleteTodo)
    }

}

@Composable
fun changeCardColorWhenCompleted(done: Boolean): Color {
    if (done){
        return MaterialTheme.colors.secondary;
    }
    else
        return MaterialTheme.colors.primary;
}
@Composable
fun changeContentColorWhenCompleted(done: Boolean): Color {
    if (done){
        return MaterialTheme.colors.onSecondary;
    }
    else
        return MaterialTheme.colors.onPrimary;
}