package ru.kolesnikov.dsl

import ru.kolesnikov.oop.Item

class ItemStore : Store<Item> {

    private val store by lazy  { HashMap<Int, Item>() }
    override fun save(model: Item): Item = store.put(model.id, model)!!
}