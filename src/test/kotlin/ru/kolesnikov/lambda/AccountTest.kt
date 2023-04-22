package ru.kolesnikov.lambda

import org.junit.jupiter.api.Test
import java.util.stream.Collectors

class AccountTest {

    @Test
    fun filterByIvanTwoResults() {
        val namePredicate = "Ivan"
        val accList: List<Account> = listOf(
            Account(namePredicate, 1),
            Account("Sergey", 1),
            Account("Vasya", 1),
            Account(namePredicate, 2),
            Account(namePredicate, -1),
            Account(namePredicate, 0)
        )

        val accounts = accList.stream()
            .filter({ a -> a.filterByName(namePredicate).test(a) })
            .collect(Collectors.toList())
        assert(accounts[0].name == namePredicate)
        assert(accounts[0].balance == 1)
        assert(accounts[1].name == namePredicate)
        assert(accounts[1].balance == 2)
        assert(accounts.size == 2)

    }

    @Test
    fun filterByIvanNoResult() {
        val namePredicate = "Ivan"
        val accList: List<Account> = listOf(
            Account(namePredicate, -100),
            Account("Sergey", 1),
            Account("Vasya", 1),
            Account(namePredicate, -2),
            Account(namePredicate, -1),
            Account(namePredicate, -3)
        )

        val accounts = accList.stream()
            .filter({ a -> a.filterByName(namePredicate).test(a) })
            .collect(Collectors.toList())
        assert(accounts.size == 0)

    }


}

