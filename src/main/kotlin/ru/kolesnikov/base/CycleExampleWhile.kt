package ru.kolesnikov.base

    fun addNew(start: Int, finish: Int): Int {
        var rsl = 0;
        for (value in start .. finish) {
            rsl += value
        }
        return rsl
    }


    fun main() {
        val rsl = addNew(0, 10)
        println("Sum from 0 to 10 is $rsl")
        var value = ForExample()
        println("\n show1 starts \n")
        value.show(1, 100)
        println("\n show1 starts \n")
        value.show1(1, 100)
        println("\n show2 starts \n")
        value.show2(1, 100)
    }