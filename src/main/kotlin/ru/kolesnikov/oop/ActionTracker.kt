package ru.kolesnikov.oop

interface ActionTracker {
    fun addString(text: String): Boolean
    fun getAll()
    fun getElement(text: String)

    fun exit(): Int
}