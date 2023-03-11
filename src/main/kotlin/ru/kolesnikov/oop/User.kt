package ru.kolesnikov.oop

class User(var name: String = "",
var surname: String = "",
var email: String = "",
var password: String = "",
var address: String = "") {

    fun show() {
        println("$name $email")
    }
}

fun main() {
    val user = User(email = "parsentev@yandex.ru", password = "secret")
    user.show()
}