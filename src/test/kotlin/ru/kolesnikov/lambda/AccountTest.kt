package ru.kolesnikov.lambda

import org.junit.jupiter.api.Test

class AccountTest {
    val namePredicate = "Ivan"

    @Test
    fun filterByIvanTwoResults() {
        val accList = listOf(
            Account(namePredicate, 1),
            Account("Sergey", 1),
            Account("Vasya", 1),
            Account(namePredicate, 2),
            Account(namePredicate, -1),
            Account(namePredicate, 0)
        )

        val accounts = filterByName(accList, namePredicate)

        assert(accounts[0].name == namePredicate)
        assert(accounts[0].balance == 1)
        assert(accounts[1].name == namePredicate)
        assert(accounts[1].balance == 2)
        assert(accounts.size == 2)

    }

    @Test
    fun filterByIvanNoResult() {
        val accList = listOf(
            Account(namePredicate, -100),
            Account("Sergey", 1),
            Account("Vasya", 1),
            Account(namePredicate, -2),
            Account(namePredicate, -1),
            Account(namePredicate, -3)
        )

        val accounts = filterByName(accList, namePredicate)
        assert(accounts.isEmpty())

    }


}

