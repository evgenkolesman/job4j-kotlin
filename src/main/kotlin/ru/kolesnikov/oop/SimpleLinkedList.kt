package ru.kolesnikov.oop

class SimpleLinkedList<T> : Iterable<T>  {

    var modCount = 0
    var head: Node<T> = Node(null)
    private var count = 0

    fun add(data: T) {
        val newNode = Node(data)
        newNode.next = this.head.next
        this.head.next = newNode
        this.count++
        this.modCount++
    }

    fun get(index: Int): T {
        if (isOutOfBounds(index)) {
            throw IndexOutOfBoundsException()
        }
        var result: Node<T> = this.head
        for (value in 0 until index) {
            result = result.next!!
        }
        return result.data!!
    }

    private fun isOutOfBounds(index: Int): Boolean {
        return index >= count || index < 0
    }

    class Node<T>(var data: T?, var next: Node<T>? = null)

    inner class LinkedIt : Iterator<T> {
        private var headIter: Node<T> = head
        private var expectedModCount: Int = modCount

        override fun hasNext(): Boolean = headIter.next != null
        override fun next(): T {
            if (expectedModCount != modCount) {
                throw IllegalArgumentException()
            }
            if (!hasNext()) {
                throw NoSuchElementException()
            }
            val result: T = headIter.next!!.data!!
            headIter = headIter.next!!
            return result
        }

    }

    override fun iterator(): Iterator<T> {
        return LinkedIt()
    }

    inner class LinkedList(): ListIterator<T> {
        var headIter: Node<T> = head
        var expectedModCount: Int = modCount


        override fun hasNext(): Boolean = headIter.next != null
        override fun next(): T {
            if (expectedModCount != modCount) {
                throw IllegalArgumentException()
            }
            if (!hasNext()) {
                throw NoSuchElementException()
            }
            val result: T = headIter.next!!.data!!
            headIter = headIter.next!!
            return result
        }

        override fun hasPrevious(): Boolean  {
            return expectedModCount - 1 < 0

        }


        override fun nextIndex(): Int {
            return expectedModCount + 1
        }

        override fun previous(): T {
            if(expectedModCount - 1 < 0) throw IndexOutOfBoundsException()
            return get(expectedModCount - 1)
        }

        override fun previousIndex(): Int {
            if(expectedModCount - 1 < 0) throw IndexOutOfBoundsException()
            return expectedModCount - 1
        }

    }

    fun listIterator(): Iterator<T> {
        return LinkedList()
    }
}

fun main() {
    val list = SimpleLinkedList<String>()
    list.add("a")
    list.add("b")
    list.add("c")
    list.iterator()
    for (value in list) {
        println(value)
    }
}