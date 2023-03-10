package ru.kolesnikov

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import ru.kolesnikov.add
import ru.kolesnikov.division
import ru.kolesnikov.multiplication
import ru.kolesnikov.subtraction

class CalcTest1 : StringSpec({
    "1 + 1 = 2" {
        add(1, 1) shouldBe 2
    }

    "1 - 1 = 0" {
        subtraction(1, 1) shouldBe 0
    }

    "1 / 1 = 1" {
        division(1, 1) shouldBe 1
    }

    "1 * 1 = 1" {
        multiplication(1, 1) shouldBe 1
    }




})
