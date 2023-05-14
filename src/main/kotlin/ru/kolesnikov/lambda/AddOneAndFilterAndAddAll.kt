package ru.kolesnikov.lambda

import java.util.function.Predicate
import kotlin.streams.toList   // this is strange it is not working without this import

class AddOneAndFilterAndAddAll {

    fun addOne(listValue: List<Int>) = listValue.map { v -> v + 1 }
    fun filterList(listValue: List<Int>, predicate: Predicate<Int>) = listValue.filter { v -> predicate.test(v) }

    fun getSum(listValue: List<Int>) = listValue.sum()

    fun addOneToAllThenFilterThenSum(listValue: List<Int>,
                                     predicate: Predicate<Int>): Int = listValue
                                                                        .stream()
                                                                        .map { v -> v + 1 }
                                                                        .filter(predicate::test)
                                                                        .toList()
                                                                        .sum()



}