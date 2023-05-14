package ru.kolesnikov.lambda

class HtmlTable {

    fun table(row: Int, cell: Int): String =
        StringBuilder().apply {
            appendLine("<table>")

            for (r in 0 until row) {
                appendLine("<row>")
                for (c in 0 until cell) {
                    append("<cell>")
                    append("</cell>")
                }
                appendLine()
                appendLine("</row>")
            }
            appendLine("</table>")


        }.toString()

}


fun main() {
    println(HtmlTable().table(2,2))
}