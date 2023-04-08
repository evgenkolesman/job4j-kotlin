package ru.kolesnikov.base

import java.util.*


class Xwrite {

    fun xWriter(d: Int) {
        val arr = Array(d) { arrayOfNulls<String>(d) }
        val bound: Int = d * 10 + d - 10
        for (i in 0 until bound) {
            if (i % 10 < d) {
                if (i / 10 == i % 10 || i / 10 + i % 10 == d - 1) arr[i / 10][i % 10] = "X"
                else arr[i / 10][i % 10] = " "
            }
        }

        Arrays.stream(arr).map(Arrays::toString).forEach(System.out::println)
    }
}