package ru.kolesnikov.lambda

object MapEx {

    @JvmStatic
    fun main(args: Array<String>) {
        val list = listOf(1, 2, 3, 4)
        val square = list.map { it * it }
        println(square)



    }
}

fun main(){
    val list = listOf(1, 2, 3, 4)
    val square = list.map { el -> el * el }
    println(square)
}