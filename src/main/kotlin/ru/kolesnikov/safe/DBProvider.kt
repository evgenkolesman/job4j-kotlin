package ru.kolesnikov.safe

import java.sql.Connection
import java.sql.DriverManager

class DBProvider {

    private lateinit var connection: Connection

    fun init() = DriverManager.getConnection(
        "jdbc:postgresql://localhost:5440/postgres",
        "postgres",
        "Password"
    )


    fun exec(sql: String): Boolean {
        connection = init()
        val prepareStatement = connection.prepareStatement(sql)
        return prepareStatement.execute()
    }
}

fun main() {
    val insertCorrect = DBProvider().exec(
        """        
        INSERT INTO kotlin.kotlin(name, comment)
            VALUES
             ('KOTLIN_NAME', 'COMMENT_KOTLIN'),
             ('KOTLIN_NAME_1', 'COMMENT_KOTLIN_1')
        """.trimIndent()
    )
    assert(insertCorrect)

    val selectCorrect =
        DBProvider()
            .exec("SELECT * FROM kotlin.kotlin".trimIndent())
    assert(selectCorrect)

    val updateCorrect =
        DBProvider()
            .exec("""
        UPDATE kotlin.kotlin SET
        name= 'KOTLIN_NAME'
        WHERE name = 'KOTLIN_NAME_1'
                    """.trimIndent())
    assert(updateCorrect)

    val deleteCorrect =
        DBProvider().exec(
                """
            DELETE FROM kotlin.kotlin WHERE name = 'KOTLIN_NAME'""".trimIndent()
            )
    assert(deleteCorrect)

}