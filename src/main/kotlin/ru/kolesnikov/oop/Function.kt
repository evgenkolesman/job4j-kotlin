package ru.kolesnikov.oop

class Function {

    val max = { x: Int, y: Int -> if (x > y) x else y }

    val decrement = {x: Int, y: Int -> x -y }

    val square = {x: Double -> Math.sqrt(x) }


}

fun main() {
    val function: Function = Function()
    println(function.max(1, 2))
    println(function.decrement(1, 2))
    println(function.square(4.0))

}