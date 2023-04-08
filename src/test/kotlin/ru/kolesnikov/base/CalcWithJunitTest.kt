package ru.kolesnikov.base

import org.junit.jupiter.api.Test

class CalcWithJunitTest {
    @Test
    fun add() {
        assert( add(1, 1) == 2)

    }

    @Test
    fun subtraction() {
        assert( subtraction(1, 1) == 0)

    }

    @Test
    fun multiplication() {
        assert( multiplication(1, 1) == 1)

    }

    @Test
    fun division() {
        assert( division(1, 1) == 1)

    }
}