package ru.kolesnikov.base

import io.kotlintest.specs.StringSpec
import org.junit.jupiter.api.Test

class XwriteTest{
    @Test
    fun XwriteTestOne():Unit = Xwrite().xWriter(1)
    @Test
    fun XwriteTestFour():Unit = Xwrite().xWriter(4)
    @Test
    fun XwriteTestSeven():Unit = Xwrite().xWriter(7)

}