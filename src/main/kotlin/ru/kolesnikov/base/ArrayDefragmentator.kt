package ru.kolesnikov.base

import java.util.*

class ArrayDefragmentator {

    public fun defragment(array: Array<String?>): Array<out Any> {

        val comparator: Comparator<in String?> = Comparator { a, b -> a!!.compareTo(b!!) }
        return Arrays.stream(array).sorted(kotlin.Comparator.nullsLast(comparator)).toArray()
    }


}