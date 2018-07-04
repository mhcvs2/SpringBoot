package com.mhc.todo.api2.service

import com.mhc.todo.api2.domain.TodoItem

interface TodoService {

    List<TodoItem> findAll()

    TodoItem findById(Long id)

    TodoItem insert(TodoItem todoItem)

    TodoItem update(TodoItem todoItem)

    void delete(Long id)

}
