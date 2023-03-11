package ru.kolesnikov.oop

class Driver {

    private val types = arrayOf('A', 'B', 'C')
    private var license = 'N'

    fun passExamOn(category: Char) {
        license = category
    }

    fun hasLicense(): Boolean {
        return types.contains(license)
    }

    fun canDrive(category: Char): Boolean {
        return this.license == category
    }

    fun main() {
        val steve = Driver();
        println("Steve wants the trucker job.")
        if (!steve.hasLicense()) {
            println("Steve need to get a license!")
            steve.passExamOn('A')
        }
        if (steve.canDrive('C')) {
            println("Steve works on truckers!")
        } else if (steve.canDrive('B')) {
            println("Steve works in taxi.")
        } else {
            println("Steve does not have a job, but ride on motorbike!");
        }
    }
}