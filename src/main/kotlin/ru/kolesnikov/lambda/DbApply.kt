package ru.kolesnikov.lambda

class DbApply {
    private val pool: Pool = Pool()

    fun getPool() = pool
    fun config() {
        pool.apply {
            driver = "org.postgres.Diver"
            url = "jdbc://localhost:5432/job4j"
            username = "postgres"
            password = "password"
        }
    }
}

fun main() {
    val db = DbApply()
    db.config()
    println(db.getPool())
}