package com.example.todo

import Status
import ToDoItem

class ToDo (private var toDoList: MutableList<ToDoItem> = mutableListOf(), private var tagList: MutableList<Tag> = mutableListOf()){
    fun addItem(item: ToDoItem): Boolean = toDoList.add(item)
    fun deleteItem(description: String):Boolean=toDoList.removeIf { it.description.equals(description) }
    fun deleteActiveItems(): Boolean = toDoList.removeIf { it.status.equals(Status.ACTIVE) }
    fun deleteDoneItems(): Boolean = toDoList.removeIf { it.status.equals(Status.DONE) }
    fun deleteAllItems() = toDoList.clear()
    fun findItem(description: String): ToDoItem? = toDoList.find{it.description.equals(description)}
    fun changeItemStatus(description: String, newStatus: Status): Boolean {
        var item = findItem(description)
        if (item != null) {
            toDoList.set(toDoList.indexOf(item),ToDoItem(item.description,newStatus))
            return true
        }
        else
            return false
    }
    fun changeItemDescription(oldDescription: String, newDescription: String, newStatus: Status): Boolean {
        var item = findItem(oldDescription)
        if (item != null) {
            toDoList.set(toDoList.indexOf(item),ToDoItem(newDescription,newStatus))
            return true
        }
        else
            return false
    }
    fun sortByStatus(status: Status): List<ToDoItem> = when(status){
        Status.ACTIVE -> toDoList.filter {it.status.equals(Status.ACTIVE)}
        Status.DONE -> toDoList.filter {it.status.equals(Status.DONE)}
        else -> toDoList
    }
    fun printToConsole(){
        for (item in toDoList){
            println(item.toString())
        }
        for (tag in tagList){
            println(tag.toString())
        }
    }
    fun addTag(tag: Tag): Boolean = tagList.add(tag)
    fun findTag(tagName: String): Tag? = tagList.find{it.name.equals(tagName)}
    fun deleteTag(tagName: String):Boolean {
        var tag = findTag(tagName)
        if (tagName != null) {
            tagList.remove(tag)
            return true
        }
        else
            return false
    }
}