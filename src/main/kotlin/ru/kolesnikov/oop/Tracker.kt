package ru.kolesnikov.oop

class Tracker private constructor() : Store {

    private val items = ArrayList<Item>()
    private var ids :Int = 1

    fun getInstance()  : Tracker = Tracker()

    fun add(item: Item): Item {
        item.id = ids
        items.add(item)
        return item
    }

    override fun addItem(item: Item): Item   {
        items.add(item)
        return item
    }


    override fun replace(id: Int, item: Item): Boolean {
        return when {
            items.size > id -> {
                items.removeAt(id)
                true
            }
            else -> false
        }
    }

    override fun delete(id: Int): Boolean {
        return when {
            items.size - 1 < id -> {
                items.removeAt(id)
                true
            }
            else -> false
        }

    }

    override fun findAll(): ArrayList<Item> = items

    override fun findByName(key: String): List<Item> =
        items
            .asSequence()
            .filter { it.name == key }
            .toList()

    override fun findById(id: Int): Item = items[id]


}