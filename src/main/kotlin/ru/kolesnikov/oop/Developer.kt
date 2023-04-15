package ru.kolesnikov.oop

class Developer:Professions() {

    override fun getName() {
        super.getName()
        println(" developer ")
    }

    override fun action() {
        super.action()
        println(" developer actions")
    }
}