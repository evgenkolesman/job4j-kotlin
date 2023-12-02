package ru.kolesnikov.lambda

data class Account(val name: String, val balance: Int) {
}
fun filterByName(list: List<Account>, stringPredicate: String): List<Account>  =
    list.filter{acc -> acc.name.equals(stringPredicate) && acc.balance > 0 }