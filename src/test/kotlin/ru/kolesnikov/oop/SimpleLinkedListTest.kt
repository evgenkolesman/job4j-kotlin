package ru.kolesnikov.oop

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

// NOT READY
class SimpleLinkedListTest {

    @Test
    fun addOneCorrect() {
        val list = SimpleLinkedList<Int>()
        list.add(1)
        assertTrue(list.iterator().next() == 1)
    }
    @Test
    fun addTwoCorrect() {
        val list = SimpleLinkedList<Int>()
        list.add(1)
        list.add(2)
        assertTrue(list.get(0) == 1)
        assertTrue(list.get(1) == 2)
    }

    @Test
    fun getOneCorrect() {
        val list = SimpleLinkedList<Int>()
        list.add(1)
        assertTrue(list.get(1) == 1)
    }

    @Test
    fun sizeOneCorrect() {
        val list = SimpleLinkedList<Int>()
        list.add(1)
        assertTrue(list.size() == 1)
    }

// @Test
//    fun removeOneCorrect() {
//        val list = SimpleLinkedList<Int>()
//        list.add(1)
//        list.remove(1)
//        assertTrue(list.size() == 0)
//    }


}