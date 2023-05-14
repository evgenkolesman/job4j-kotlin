package ru.kolesnikov.lambda

import java.util.stream.Collectors

class ExampleTerminalFilterAndMap {
}
fun main() {
    val list = listOf(1, 2, 3, 4)
    val filtered = list.filter { it % 2 == 0 }  //terminal method produces list
    println(filtered)

    val mapped = filtered.map { it * it } //terminal method produces list
    println(mapped)


    val mapped1 = list.filter { it % 2 == 0 } .map { it * it }  //terminal method produces list twice bad decisicion need to doit with stream() like in java
    println(mapped1)


    val mapped2 = list               //best choice to mix this methods
        .stream()
        .filter { it % 2 == 0 }
        .map { it * it }
        .collect(Collectors.toList())
    println(mapped2)
}
