package com.example.todolist.model

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class TodoViewModel: ViewModel() {

    var todoList = mutableStateListOf<Todo>()

    fun add(newBook: Todo){
        todoList.add(newBook)
    }

    fun delete(book: Todo) {
        todoList.remove(book)
    }
}