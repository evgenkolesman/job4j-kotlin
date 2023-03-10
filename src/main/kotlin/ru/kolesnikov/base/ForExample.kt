package ru.kolesnikov.base

class ForExample {

    fun show(start: Int, finish: Int) {
        for (value in start until finish) {
            print(" $value")
        }
    }

    fun show1(start: Int, finish: Int) {
        for (value in start .. finish step 2) {
            print(" $value")
        }
    }


    fun show2(start: Int, finish: Int) {
        for (value in finish downTo start step 2) {
            print(" $value")
        }
    }


}