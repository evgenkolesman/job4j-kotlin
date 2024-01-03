package ru.kolesnikov.dsl

interface Store <T> {
    fun save(model: T): T
}