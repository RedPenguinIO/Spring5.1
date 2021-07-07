package io.peng.demo.controller

import io.peng.demo.data.Note
import io.peng.demo.data.Todo
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/notes")
@SpringBootApplication(
    exclude = [DataSourceAutoConfiguration::class]
)
class NoteController {

    //Get notes
    @RequestMapping(method= [(RequestMethod.GET)], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getNotes(): List<Note>{
        return listOf(Note(UUID.randomUUID().toString(),"My first note", "This is a message for the first note"),
            Note(UUID.randomUUID().toString(),"My second note", "This is a message for the 2nd note"))
    }

    //Insert new notes. Consumes JSON

    @RequestMapping(method= [(RequestMethod.PUT)],consumes=[MediaType.APPLICATION_JSON_VALUE])
    fun insertNote(@RequestBody note: Note): Note{
        note.id = UUID.randomUUID().toString()
        return note
    }

    //Remove note by ID, Introduce path variable for ID to pass
    @RequestMapping(method = [RequestMethod.DELETE],value=["/delete/{id}"],produces = [MediaType.APPLICATION_JSON_VALUE])
    fun deleteNote(@PathVariable(name="id")id:String):Boolean{
        println("Removing: $id")
        return true
    }

    //Update an item, consumes JSON, returns updated Note
    @RequestMapping(method=[RequestMethod.POST], produces= [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE] )
    fun UpdateTodo(@RequestBody todo: Todo): Todo {
        todo.title += "Updated"
        todo.message += "Updated"
        todo.schedule = System.currentTimeMillis()
        return todo
    }
}

