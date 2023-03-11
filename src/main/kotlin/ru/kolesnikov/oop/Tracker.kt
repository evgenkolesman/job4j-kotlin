package ru.kolesnikov.oop

class Tracker private constructor() : Store {

    private val items = ArrayList<Item?>()
    private var ids :Int = 1

    fun getInstance()  : Tracker = Tracker()

    fun add(item: Item): Item {
        item.setId(ids)
        items.add(item)
        return item
    }

    override fun add(item: Item?): Item?   {
        items.add(item)
        return item
    }


    override fun replace(id: Int, item: Item?): Boolean {
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

    override fun findAll(): List<Item?> = items

    override fun findByName(key: String?): List<Item?> =
        items
            .asSequence()
            .filterNotNull()
            .filter { it.getName().equals(key) }
            .toList()

    override fun findById(id: Int): Item? = if(items.size > id) items.get(id) else null


}