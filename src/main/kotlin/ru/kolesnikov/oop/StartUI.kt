package ru.kolesnikov.oop

import java.util.*

object StartUI {

    private val cache = ArrayList<String>()

    @JvmStatic
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
            if (nextLine.startsWith("/add")) addString(nextLine)
            if (nextLine.startsWith("/get")) getAll()
            if (nextLine.startsWith("/element")) getElement(nextLine)
            if (nextLine.startsWith("/end")) exit = exit()
        }

    }

   private fun addString(text : String) = this.cache.add(String.format(" \"%s\" " , text.replace("/add ", "")))
   private fun getAll() = println(cache)
   private fun getElement(text: String)  {
       val index = text.replace("/element", "")

       if(text
           .replace("/element", "")
           .trim() == "") println("введите индекс")
       else if(index
           .trim()
           .toInt() > cache.size) println("Индекс введен не корректно введите его в рамках длины " + cache.size)
       else println(cache[index.trim().toInt() - 1])
   }
    private fun exit(): Int = 1
}