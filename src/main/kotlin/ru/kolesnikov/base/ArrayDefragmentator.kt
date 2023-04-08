package ru.kolesnikov.base

import java.util.*
import kotlin.Comparator

class ArrayDefragmentator {

    public fun defragment(array: Array<String?>): Array<out Any> {
        if(array.contentEquals(arrayOfNulls(array.size))) array
        val comparator: Comparator<in String?> = Comparator { a, b -> a!!.compareTo(b!!) }
        return Arrays.stream(array)
            .sorted(Comparator.nullsLast(comparator))
            .toArray()
    }


}