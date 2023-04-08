package ru.kolesnikov.base

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class ArrayDefragmenatatorTest :StringSpec( {
        "FirstAThirdBSeventhC"{
            val a = ArrayDefragmentator()
            val names = arrayOfNulls<String>(10)
            names[7] = "c"
            names[1] = "a"
            names[3] = "b"

            val res = a.defragment(names)
           ( res[0].equals("a")  && res[1].equals("b")  && res[2].equals("c")  && res[3] == null)  shouldBe true
        }
        "FirstAThirdASeventhA"{
            val a = ArrayDefragmentator()
            val names = arrayOfNulls<String>(10)
            names[7] = "a"
            names[1] = "a"
            names[3] = "a"

            val res = a.defragment(names)
           ( res[0].equals("a") && res[1].equals("a")  && res[2].equals("a")  && res[4] == null )  shouldBe true
        }
        "WithNullInBetween"{
            val a = ArrayDefragmentator()
            val names = arrayOfNulls<String>(10)
            names[1] = "a"
            names[2] = null
            names[3] = "a"

            val res = a.defragment(names)
           ( res[0].equals("a") && res[1].equals("a") && res[2] == null && res[3] == null )  shouldBe true
        }
        "WithAllNull"{
            val a = ArrayDefragmentator()
            val names = arrayOfNulls<String>(10)
                 val res = a.defragment(names)
           names.contentEquals(arrayOfNulls<String>(10))  shouldBe true
        }

    })
