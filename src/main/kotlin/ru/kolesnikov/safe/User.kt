package ru.kolesnikov.safe

data class User(var name: String = "",
                var surname: String = "",
                var email: String = "",
                var password: String = "",
                var passportNumber: String = "",
                var address: String = "")
