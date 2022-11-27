package com.example.todolist.ui.compose

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.todolist.R
import com.example.todolist.model.Todo
import java.util.*

@Composable
fun addBookDialog(context: Context, dismissDialog:() -> Unit, addTodo: (Todo) -> Unit){
    var titleTextField by remember {
        mutableStateOf("")
    }

    var contentTextField by remember {
        mutableStateOf("")
    }

    var authorTextField by remember {
        mutableStateOf("")
    }

    AlertDialog(
        onDismissRequest = { dismissDialog},
        title={Text(text = stringResource(id = R.string.addTodo), style = MaterialTheme.typography.h6)},
        text = {
            Column(modifier = Modifier.padding(top=20.dp)) {
                TextField(label = {Text(text=stringResource(id = R.string.titleName))}, value = titleTextField, onValueChange = {titleTextField=it})
                Spacer(modifier = Modifier.height(10.dp))
                TextField(label = {Text(text=stringResource(id = R.string.contentName))},value = contentTextField, onValueChange = {contentTextField=it})
                Spacer(modifier = Modifier.height(10.dp))
                TextField(label = {Text(text=stringResource(id = R.string.authorName))},value = authorTextField, onValueChange = {authorTextField=it})
            }
        },
        confirmButton = {
            Button(onClick = {
                if(titleTextField.isNotEmpty()) {
                    val newID = UUID.randomUUID().toString();
                    addTodo(Todo(newID, titleTextField, contentTextField, authorTextField))
                    Toast.makeText(
                        context,
                        context.resources.getString(R.string.todoAdded),
                        Toast.LENGTH_SHORT
                    ).show()
                }
                dismissDialog()
            })
            {
                Text(text = stringResource(id = R.string.add))
            }
        },dismissButton = {
            Button(onClick = {
                dismissDialog()
            }) {
                Text(text = stringResource(id = R.string.cancel))
            }
        }
    )
}