package ru.kolesnikov.lambda

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.util.*

class CampaingTest {

    @Test
    fun stringNameAddressValueDate() {
        val list = listOf(
            Campaing("First", Address("Street 1", 1), Date()),
            Campaing("Second", Address("Street 2", 2), Date()),
            Campaing("Third", Address("Street 3", 3), Date())
        ).map { it.stringNameAddressValueDate() }
            .toList()
        assertEquals("name = First, address = Street 1, date = %s".format(LocalDate.now()), list[0])
        assertEquals("name = Second, address = Street 2, date = %s".format(LocalDate.now()), list[1])
        assertEquals("name = Third, address = Street 3, date = %s".format(LocalDate.now()), list[2])
    }
}