package ru.kolesnikov.oop

class Carpenter: Professions() {

    override fun getName() {
        super.getName()
        println(" carpenter ")
    }

    override fun action() {
        super.action()
        println(" carpenter  actions")
    }
}