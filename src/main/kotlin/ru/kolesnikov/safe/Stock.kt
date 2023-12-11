package ru.kolesnikov.safe

import java.time.Instant

class Stock(var name:String?, var currency: String?, var date: Instant?) {


    override fun equals(other: Any?): Boolean {

        return if(other is Stock) {

            if (other.name == this.name &&
                other.currency == this.currency &&
                other.date == this.date
            ) true
            else {
                ((other.name != null && other.name.equals(this.name))
                        && (other.currency != null && other.currency.equals(this.currency))
                        && (other.date != null && other.date == this.date))
            }
        } else false
    }

    override fun hashCode(): Int {
        var result = name?.hashCode() ?: 0
        result += result + (currency?.hashCode() ?: 0)
        result += result + (date?.hashCode() ?: 0)
        return result
    }


}