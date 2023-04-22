package ru.kolesnikov.lambda

import java.util.function.Predicate

data class Account(val name: String, val balance: Int) {

    fun filterByName(stringPredicate: String): Predicate<Account>  =
        Predicate{ this.name == stringPredicate && this.balance > 0 }

}
