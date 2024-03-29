package com.example.todo
import ToDoItem
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.CommandLineRunner

@SpringBootApplication
open class ToDoApplication:CommandLineRunner {
    var logger: Logger = LoggerFactory.getLogger(ToDoApplication::class.java)

    override fun run(vararg args: String?) {
        logger.info("EXECUTING: cmd runner")
        var toDo: ToDo = ToDo()

        while(true){
            println("Введите команду из списка: addItem,addTag,deleteItem,deleteTag,printToConsole,exit")
            when(readLine()!!.toString()){
                "addItem" -> {
                    println("Введите описание")
                    toDo.addItem(ToDoItem(readLine()!!.toString()))
                }
                "addTag" -> {
                    println("Введите описание")
                    toDo.addTag(Tag(readLine()!!.toString()))
                }
                "printToConsole" -> {
                    toDo.printToConsole()
                }
                "exit" -> {
                    break
                }
                else -> continue
            }
        }
    }
}

fun main(args: Array<String>){
    runApplication<ToDoApplication>(*args)

}