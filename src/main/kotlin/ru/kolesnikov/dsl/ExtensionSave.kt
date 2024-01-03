package ru.kolesnikov.dsl

import ru.kolesnikov.oop.Item

//But in that case ItemStore must be a singleton to work it well
fun Item.save() = ItemStore().save(this)


fun main() {
    val item = Item("name", 1)
    item.save()
}