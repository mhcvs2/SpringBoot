package com.mhc.todo.api2.service

import com.mhc.todo.api2.domain.TodoItem
import com.mhc.todo.api2.mapper.TodoItemMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TodoServiceImpl implements TodoService {

    @Autowired
    TodoItemMapper todoItemMapper

    @Override
    List<TodoItem> findAll() {
        todoItemMapper.findAll()
    }

    @Override
    TodoItem findById(Long id) {
        todoItemMapper.findById(id)
    }

    @Override
    TodoItem insert(TodoItem todoItem) {
        todoItemMapper.insert(todoItem)
        todoItem
    }

    @Override
    TodoItem update(TodoItem todoItem) {
        todoItemMapper.update(todoItem)
        todoItem
    }

    @Override
    void delete(Long id) {
        todoItemMapper.delete(id)
    }
}
