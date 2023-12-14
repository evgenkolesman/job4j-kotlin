package ru.kolesnikov.oop

class SimpleLinkedList<T> : Iterable<T>  {

    private var modCount = 0
    private var head: Node<T> = Node(null)
    private var count = 0

    fun add(data: T) {
        val newNode = Node(data)
        newNode.next = head.next
        head.next = newNode
        count++
        modCount++
    }

    fun get(index: Int): T {
        if (isOutOfBounds(index)) {
            throw IndexOutOfBoundsException()
        }
        var result: Node<T> = head
        for (value in 0 ..  index) {
            result = result.next!!
        }
        return result.data!!
    }

    private fun isOutOfBounds(index: Int) = index >= count || index < 0


    class Node<T>(var data: T?, var next: Node<T>? = null)

    inner class LinkedIt : Iterator<T> {
        private var headIter = head
        private var expectedModCount: Int = modCount

        override fun hasNext() = headIter.next != null
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

    inner class LinkedList : ListIterator<T> {
        private var headIter = head
        private var expectedModCount = modCount


        override fun hasNext() = headIter.next != null
        override fun next(): T {
            if (expectedModCount != modCount) {
                throw IllegalArgumentException()
            }
            if (!hasNext()) {
                throw NoSuchElementException()
            }
            val result = headIter.next!!.data!!
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