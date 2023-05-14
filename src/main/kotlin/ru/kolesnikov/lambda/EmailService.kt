package ru.kolesnikov.lambda

class EmailService {
    fun emailTo(message: Message): String =
        with(StringBuilder()) {
            append("Subject : ").appendLine(message.email)
            append("Body : ").append("Hello, ").appendLine(message.email)
            append("You win!")
            toString()
        }
}

fun main() {
    println(EmailService().emailTo(Message("Arcadiy", "Arcadiy@mail.ru")))
}