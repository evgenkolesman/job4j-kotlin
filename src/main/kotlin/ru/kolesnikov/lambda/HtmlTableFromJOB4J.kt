package ru.kolesnikov.lambda

class HtmlTableFromJOB4J {
    fun table(row: Int, cell: Int): String =  with(StringBuilder()) {
        append("<table>")
        for (rows in 0..row) {
            append("<tr>")
            for (cells in 0..cell) {
                append("<td></td>")
            }
            append("</tr>")
        }
        append("</table>")
        }.toString()
    }


fun main() {
    println(HtmlTable().table(2, 2))
}