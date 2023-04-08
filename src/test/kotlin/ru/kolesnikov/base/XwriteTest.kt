package ru.kolesnikov.base

import org.junit.jupiter.api.Test

class XwriteTest{
    @Test
    fun xwriteTestOne():Unit = Xwrite().xWriter(1)
    @Test
    fun xwriteTestFour():Unit = Xwrite().xWriter(4)
    @Test
    fun xwriteTestSeven():Unit = Xwrite().xWriter(7)

}