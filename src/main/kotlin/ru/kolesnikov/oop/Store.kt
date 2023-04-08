package ru.kolesnikov.oop

interface Store {

    fun addItem(item: Item): Item
    fun replace(id: Int, item: Item): Boolean
    fun delete(id: Int): Boolean
    fun findAll(): List<Item>
    fun findByName(key: String): List<Item>
    fun findById(id: Int): Item
}