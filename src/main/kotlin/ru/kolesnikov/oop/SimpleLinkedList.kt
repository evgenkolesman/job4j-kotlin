import java.lang.IllegalArgumentException

class SimpleLinkedList<T> : Iterable<T> {

    var modCount = 0
    var head: Node<T> = Node(null)
    var count = 0

    fun add(data: T) {
        val newNode: Node<T> = Node(data)
        newNode.next = this.head.next
        this.head.next = newNode
        this.count++
        this.modCount++
    }

    fun get(index: Int): T {
        if (isOutOfBounds(index)) {
            throw ArrayIndexOutOfBoundsException()
        }
        var result: Node<T> = this.head
        for (value in 0..index + 1) {
            result = result.next!!
        }
        return result.data!!
    }

    fun isOutOfBounds(index: Int): Boolean {
        return index >= count || index < 0
    }

    class Node<T>(var data: T?, var next: Node<T>? = null)

    inner class LinkedIt(): Iterator<T> {
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

    }

    override fun iterator(): Iterator<T> = LinkedIt()
    
}

fun main() {
    val list = SimpleLinkedList<String>()
    list.add("a")
    list.add("b")
    list.add("c")
    for (value in list) {
        println(value)
    }
}