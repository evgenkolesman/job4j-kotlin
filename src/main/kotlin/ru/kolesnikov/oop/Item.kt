package ru.kolesnikov.oop

class Item {
    private var name: String
    private var id: Int

    constructor(name: String, id: Int) {
        this.name = name
        this.id = id
    }

    fun getName() = name
    fun getId() = id

    fun setName(nameToSet : String) {
        name = nameToSet
    }
    fun setId(idToSet : Int) {
        id = idToSet
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Item

        if (name != other.name) return false
        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + id
        return result
    }


}