package ru.kolesnikov.lambda

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.util.function.Predicate

class AddOneAndFilterAndAddAllTest {

    val inst: AddOneAndFilterAndAddAll = AddOneAndFilterAndAddAll()

    @Test
    fun addOne() {
        assertEquals(inst.addOne(listOf(1, 2, 3, 4, 5, 6)), listOf(2,3,4,5,6,7))
        assertNotEquals(inst.addOne(listOf(1, 2, 3, 4, 5, 6)), listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun filterList() {
        assertEquals(
            inst.filterList(listOf(1, 2, 3, 4, 5, 6), { a -> a % 2 == 0}),
            listOf(2,4,6)
        )
        assertNotEquals(
            inst.filterList(listOf(1, 2, 3, 4, 5, 6), { a -> a % 2 == 0}),
            listOf(1,3,5)
        )
    }

    @Test
    fun getSum() {
        assertEquals(
            inst.getSum(listOf(1, 2, 3, 4, 5, 6)),
            21)
    }

    @Test
    fun addOneToAllThenFilterThenSum() {
        assertEquals(
            inst.addOneToAllThenFilterThenSum(listOf(1, 2, 3, 4, 5, 6), { a -> a % 2 == 0}),
            12)
    }
}