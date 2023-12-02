package ru.kolesnikov.safe

import org.junit.jupiter.api.Test
import java.time.Instant
import java.util.*

class PurchaseTest{

    @Test
    fun printTable() {
        val html = getHtml(
            listOf(
                Purchase("Name", Date.from(Instant.now()), null),
                Purchase("Name", Date.from(Instant.now()), Address("Street", "home", "zip"))

            ))

        intoStream(html, System.out)

    }

    @Test
    fun checkTable() {


    }
}