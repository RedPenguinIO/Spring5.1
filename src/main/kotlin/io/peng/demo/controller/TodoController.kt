package io.peng.demo.controller

import io.peng.demo.data.Todo
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/todos")
class TodoController {
    //Get Todos
    @RequestMapping(method = [RequestMethod.GET],produces=[MediaType.APPLICATION_JSON_VALUE])
    fun getTodos(): List<Todo>{
        return listOf(Todo(UUID.randomUUID().toString(),"My first Todo","This is the message fo rmy first Todo",System.currentTimeMillis()),
            Todo(UUID.randomUUID().toString(),"My second Todo","This is the message for my second Todo",System.currentTimeMillis()))
    }

    //Insert item, consumes JSON
    @RequestMapping(method = [RequestMethod.PUT],produces = [MediaType.APPLICATION_JSON_VALUE],consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun insertTodo(@RequestBody todo: Todo):Todo{
        todo.id = UUID.randomUUID().toString()
        return todo
    }

    //Remove item by ID
    @RequestMapping(method = [RequestMethod.DELETE],produces = [MediaType.APPLICATION_JSON_VALUE])
    fun deleteTodo(@PathVariable(name="id") id:String):Boolean{
        println("Removing: $id")
        return true
    }

    //Update an item
    @RequestMapping(method = [RequestMethod.POST],produces = [MediaType.APPLICATION_JSON_VALUE],consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun updateTodo(@RequestBody todo:Todo): Todo{
        todo.title+="Updated"
        todo.message+="Updated"
        todo.schedule= System.currentTimeMillis()
        return todo
    }
}