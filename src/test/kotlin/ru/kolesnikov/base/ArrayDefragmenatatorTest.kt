package ru.kolesnikov.base

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import kotlin.test.assertNull

class ArrayDefragmenatatorTest :StringSpec( {
        "FirstAThirdBSeventhC"{
            val a = ArrayDefragmentator()
            val names = arrayOfNulls<String>(10)
            names[7] = "c"
            names[1] = "a"
            names[3] = "b"

            val res = a.defragment(names)
            assertNull(res[3])
            ( res[0].equals("a")  && res[1].equals("b")  && res[2].equals("c"))  shouldBe true
        }
        "FirstAThirdASeventhA"{
            val a = ArrayDefragmentator()
            val names = arrayOfNulls<String>(10)
            names[7] = "a"
            names[1] = "a"
            names[3] = "a"

            val res = a.defragment(names)
            assertNull(res[4])
           ( res[0].equals("a") && res[1].equals("a")  && res[2].equals("a") )  shouldBe true
        }
        "WithNullInBetween"{
            val a = ArrayDefragmentator()
            val names = arrayOfNulls<String>(10)
            names[1] = "a"
            names[2] = null
            names[3] = "a"

            val res = a.defragment(names)
            assertNull(res[2])
            assertNull(res[3])
           ( res[0].equals("a") && res[1].equals("a") )  shouldBe true
        }
        "WithAllNull"{
            val a = ArrayDefragmentator()
            val names = arrayOfNulls<String>(10)
            val res = a.defragment(names)
           res.contentEquals(arrayOfNulls<String>(10))  shouldBe true
        }

    })
