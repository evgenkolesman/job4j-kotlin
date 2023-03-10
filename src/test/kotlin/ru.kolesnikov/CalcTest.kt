package ru.kolesnikov

import org.junit.jupiter.api.Test

class CalcTest () {
    @Test
    fun add() {
        assert( ru.kolesnikov.base.add(1, 1) == 2)

    }

    @Test
    fun subtraction() {
        assert( ru.kolesnikov.base.subtraction(1, 1) == 0)

    }

    @Test
    fun multiplication() {
        assert( ru.kolesnikov.base.multiplication(1, 1) == 1)

    }

    @Test
    fun division() {
        assert( ru.kolesnikov.base.division(1, 1) == 1)

    }
}