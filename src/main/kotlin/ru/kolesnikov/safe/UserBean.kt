package ru.kolesnikov.safe

class UserBean {
    val emails : List<String> by lazy { loadEmails() }
    val cities : List<String> by lazy { loadCities() }

    private fun loadEmails() : List<String> = listOf("parsentev@yandex.ru")
    private fun loadCities() : List<String> = listOf("Volgograd", "Samara", "Sochi", "Sevastopol")
}

fun main() {
    val user = UserBean()
    println(user.emails)
    println(user.cities)

}