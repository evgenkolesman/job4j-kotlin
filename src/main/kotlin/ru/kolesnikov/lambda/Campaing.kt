package ru.kolesnikov.lambda

import java.text.MessageFormat
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

data class Campaing(val name: String,val address: Address,val created: Date) {

fun stringNameAddressValueDate() : String =
    MessageFormat.format("name = {0}, address = {1}, date = {2}",
        this.name,
        this.address.addressValue,
        LocalDate.ofInstant(this.created.toInstant(), ZoneId.systemDefault()).toString())


}

data class Address (val addressValue: String, val id: Int)
