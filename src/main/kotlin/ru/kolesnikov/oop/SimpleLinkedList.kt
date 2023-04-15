package ru.kolesnikov.oop

import java.util.*

// NOT READY
class SimpleLinkedList<T> : Iterable<T> {
    private var head : Node<T>? = null

//    fun add(value: T) {
//        head = if (head != null) {
//            Node(head!!.value, Node(value))
//        } else Node(value)
//    }

    fun add(value: T) {
        if (head != null) {
            head = Node<T>(value)
        }
    }
    fun get(value: Int) :T?  {
        var n = 0
        var element: T
        if(value == 0 ) return this.iterator().next()
        else do {
           element = this.iterator().next()
            n += 1
        } while(n != value)
        return element
    }

    fun size():Int {
        var n = 0
        while (this.iterator().hasNext()) {
            this.iterator().next()
            n++
        }
        return n
    }

    fun remove(value:T) {
        while (this.iterator().hasNext()) {
            if(this.iterator().next() == value)  head = null
        }
    }

    override fun iterator(): Iterator<T> {
        return LinkedIt()
    }

    inner class LinkedIt : Iterator<T> {
        override fun hasNext(): Boolean {
            return head != null
        }

        override fun next(): T {
            if (!hasNext()) {
                throw NoSuchElementException()
            }
            return head!!.value
        }

    }

    class Node<K>(val value: K, var next: Node<K>? = null)
}

//fun main() {
//    val node = SimpleLinkedList.Node("Kotlin")
//    val list = SimpleLinkedList<String>()
//    for (value in list) {
//        println(value)
//    }
//}