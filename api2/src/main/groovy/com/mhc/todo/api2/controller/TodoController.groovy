package com.mhc.todo.api2.controller

import com.mhc.todo.api2.domain.TodoItem
import com.mhc.todo.api2.service.TodoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping(value = "/api")
class TodoController {

    @Autowired
    TodoService todoService

    @GetMapping("/todos")
    @ResponseBody
    List<TodoItem> find(){
        todoService.findAll()
    }

    @GetMapping("/todos/{id}")
    @ResponseBody
    TodoItem findById(@PathVariable('id') Long id){
        todoService.findById(id)
    }

    @PostMapping("/todos")
    @ResponseBody
    TodoItem insert(@RequestBody TodoItem todoItem) {
        todoService.insert(todoItem)
    }

    @PutMapping("/todos")
    @ResponseBody
    TodoItem update(@RequestBody TodoItem todoItem) {
        todoService.update(todoItem)
    }

    @DeleteMapping("/todos/{id}")
    @ResponseBody
    void delete(@PathVariable("id") Long id) {
        todoService.delete(id)
    }
}
