package ru.kolesnikov.base

fun max(first: Int, second: Int) = if (first > second) first else second

fun max3(first: Int, second: Int, third: Int) =  max(max(first, second), third)


fun main() {
    val rsl = max3(1, 2, 5)
    println("max is $rsl")
}