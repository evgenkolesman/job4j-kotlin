package ru.kolesnikov.oop

class SimpleLinkedList<T> : Iterable<T>, ListIterator<T> {
    private var head: Node<T>? = null
    fun add(value: T) {
        if (head != null) {
            head = Node(value, null)
        }
    }

    fun size() = this.count()

    override fun iterator(): Iterator<T> {
        return LinkedIt()
    }

    fun get(index: Int): T? {
        var res: T? = null
        if (index < size() - 1) {
            var ind = 0
            while (ind == index) {
                res = iterator().next()
                ind++
            }
        } else throw IndexOutOfBoundsException()
        return res
    }

    inner class LinkedIt(val size: Int = 0) : Iterator<T> {

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


    override fun hasNext(): Boolean = this.next() != null


    override fun hasPrevious(): Boolean = indexOf<Any?>(element = this) - 1 > 0

    override fun next(): T {
        return if (hasNext()) {
            this.head!!.value
        } else throw IllegalArgumentException("No value next")
    }


    override fun nextIndex(): Int {
        var count = 0
        while (hasNext()) count++
        return count + 1
    }

    override fun previous(): T {
        if (hasPrevious()) {
            return this.get(indexOf<Any?>(this) - 1)!!
        } else throw IndexOutOfBoundsException()
    }

    override fun previousIndex(): Int {
        val i = indexOf<Any?>(this) - 1
        if (i < 0) throw IndexOutOfBoundsException()
        return i
    }
}

fun main() {
    val list = SimpleLinkedList<String>()
    for (value in list) {
        println(value)
    }
}