package ru.kolesnikov.lambda

class FilterEx {

}

fun main() {
    val predicate = { e: Int -> e % 2 == 0 }
    val list = listOf(1, 2, 3, 4)
    val filtered = list.filter(predicate)
    println(filtered) }