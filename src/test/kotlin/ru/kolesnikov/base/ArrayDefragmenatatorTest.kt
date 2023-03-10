package ru.kolesnikov.base

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class ArrayDefragmenatatorTest :StringSpec( {
        "1"{
            val a = ArrayDefragmentator()
            val names = arrayOfNulls<String>(10)
            names[7] = "c"
            names[1] = "a"
            names[3] = "b"

            val res = a.defragment(names)
           ( res[0] != null && res[1] != null && res[2] != null && res[3] == null)  shouldBe true
        }
        "2"{
            val a = ArrayDefragmentator()
            val names = arrayOfNulls<String>(10)
            names[7] = "a"
            names[1] = "a"
            names[3] = "a"

            val res = a.defragment(names)
           ( res[0] != null && res[1] != null && res[2] != null&& res[3] == null )  shouldBe true
        }

    })
