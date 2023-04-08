package ru.kolesnikov.oop

import java.util.*

class StartUI private constructor() {
    companion object {
        internal val cache = ArrayList<String>()
        internal fun addString(text: String) = this.cache.add(String.format(" \"%s\" ", text.replace("/add ", "")))
        internal fun getAll() = println(cache)
        internal fun getElement(text: String) {
            val index = text.replace("/element", "")

            if (text.replace("/element", "")
                    .trim() == "") println("введите индекс")
            else if (index
                    .trim()
                    .toInt() > cache.size
            ) println("Индекс введен не корректно введите его в рамках длины " + cache.size)
            else println(cache[index.trim().toInt() - 1])
        }

        internal fun exit(): Int = 1

    }
}

fun main(args: Array<String>) {
    var exit = 0

    while (exit != 1) {
        println(
            """
            Здравствуйте введите команду:
            - /add чтобы добавить запись, на этой же строчке введите запись
            - /get чтобы вывести список записей
            - /element чтобы вывести элемент из кэша записей
            запрос выглядит так 
            /element index(числовое значение)
            - /end чтобы закончить
        """.trimIndent()
        )
        val scanner = Scanner(System.`in`)
        val nextLine = scanner.nextLine()
        if (nextLine.startsWith("/add")) StartUI.Companion.addString(nextLine)
        if (nextLine.startsWith("/get")) StartUI.Companion.getAll()
        if (nextLine.startsWith("/element")) StartUI.Companion.getElement(nextLine)
        if (nextLine.startsWith("/end")) exit = StartUI.Companion.exit()
    }

}
