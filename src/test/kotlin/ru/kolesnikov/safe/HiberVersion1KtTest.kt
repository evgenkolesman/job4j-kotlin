package ru.kolesnikov.safe

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import ru.kolesnikov.oop.Item

class HiberVersion1KtTest {

    @Test
    fun save() {
        val item = Item("name")
        val id = item.save()
        item.id = id

        item eq item.getById()
        item notEq  Item("name1", 1)

        item.delete()

    }


    @Test
    fun listContains() {

        val elements = Item("name", 1)
        val list = listOf(Item("name1", 1), elements)
        assertTrue(list contains elements)

    }

}


infix fun<T> Item.eq(expected:T) = assertEquals(expected, this)
infix fun<T> Item.notEq(expected:T) = assertNotEquals(expected, this)
infix fun<T> List<T>.contains(expected:T): Boolean = this.contains(expected)