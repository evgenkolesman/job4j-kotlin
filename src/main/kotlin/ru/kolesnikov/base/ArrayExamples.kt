package ru.kolesnikov.base

class ArrayExamples {
    fun createArray() {
        val names =  arrayOfNulls<String>(10)
        names[0] = "Petr Arsentev"
        for (name in names) {
            println(name?.length) //not null
        }
    }

    fun createArrayList() {
        val names = ArrayList<String>()
        names.add("Petr Arsentev")
        for (name in names.withIndex()) { //withIndex() - gives index of value
            println(name)
        }
    }


}