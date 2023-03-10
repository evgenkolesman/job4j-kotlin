package ru.kolesnikov

fun max(first: Int, second: Int) = if (first > second) first else second

fun max3(first: Int, second: Int, third: Int) = if( third > max(first, second)) third else max(first, second)
fun main() {
    val rsl = max3(1, 2, 5)
    println("max is $rsl")
}