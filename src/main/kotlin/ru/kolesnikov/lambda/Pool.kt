package ru.kolesnikov.lambda

class Pool {
    var driver: String = ""
    var url: String = ""
    var username: String = ""
    var password: String = ""

    override fun toString(): String {
        return """driver ${driver} 
            |url ${url} 
            |username ${username} 
            |password $password""".trimMargin()
    }
}