package ru.kolesnikov.oop

object MemStore {
    private val data = ArrayList<String>()

    fun addData(value: String) {
        data.add(value)
    }

    fun getAllData() = data
}

fun main() {
    MemStore.addData("Petr Arsentev")
    println("${MemStore.getAllData()}")
}