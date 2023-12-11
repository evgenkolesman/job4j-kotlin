package ru.kolesnikov.safe

import org.junit.jupiter.api.Test
import java.time.Instant
import java.time.temporal.ChronoUnit
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals

class StockTest {

    @Test
    fun allFieldCorrectNullAssert() {
        val stock = Stock("Name",
            "EUR",
            Instant.now().truncatedTo(ChronoUnit.SECONDS))
        assertFalse { stock.equals(null) }
    }

    @Test
    fun allFieldCorrectSameOne() {
        val stock = Stock("Name",
            "EUR",
            Instant.now().truncatedTo(ChronoUnit.SECONDS))
        assert(stock == stock)
        assert(stock.hashCode() == stock.hashCode())
    }

    @Test
    fun allFieldCorrectSameFields() {
        val stock = Stock("Name",
            "EUR",
            Instant.now().truncatedTo(ChronoUnit.SECONDS))
        val stockSame = Stock("Name",
            "EUR",
            Instant.now().truncatedTo(ChronoUnit.SECONDS))
        assert(stock == stockSame)
        assert(stock.hashCode() == stockSame.hashCode())
    }

    @Test
    fun allFieldCorrectSameFieldsWithNull() {
        val stock = Stock("Name",
            "EUR",
            null)
        val stockSame = Stock("Name",
            "EUR",
            null)
        assert(stock == stockSame)
        assert(stock.hashCode() == stockSame.hashCode())
    }

    @Test
    fun allFieldCorrectSameFieldsWithNullTwoFields() {
        val stock = Stock("Name",
            null,
            null)
        val stockSame = Stock("Name",
            null,
            null)
        assert(stock == stockSame)
        assert(stock.hashCode() == stockSame.hashCode())
    }
    @Test
    fun allFieldCorrectSameFieldsWithNullAll() {
        val stock = Stock(null,
            null,
            null)
        val stockSame = Stock(null,
            null,
            null)
        assert(stock == stockSame)
        assert(stock.hashCode() == stockSame.hashCode())
    }

    @Test
    fun allFieldCorrectNullCurrency() {
        val stock = Stock("Name",
            null,
            Instant.now().truncatedTo(ChronoUnit.SECONDS))
        val stockSame = Stock("Name",
            null,
            Instant.now().truncatedTo(ChronoUnit.SECONDS))
        assert(stock == stockSame)
        assert(stock.hashCode() == stockSame.hashCode())
    }

    @Test
    fun allFieldCorrectNullName() {
        val stock = Stock(
            null,
            "EUR",
            Instant.now().truncatedTo(ChronoUnit.SECONDS)
        )
        val stockSame = Stock(
            null,
            "EUR",
            Instant.now().truncatedTo(ChronoUnit.SECONDS)
        )
        assert(stock == stockSame)
        assert(stock.hashCode() == stockSame.hashCode())
    }

    @Test
    fun allFieldCorrectNotSameFields() {
        val stock = Stock("Name",
            "EUR",
            Instant.now().truncatedTo(ChronoUnit.SECONDS))
        val stockSame = Stock("Name1",
            "EUR2",
            Instant.now().plusSeconds(12).truncatedTo(ChronoUnit.SECONDS))
        assertNotEquals(stock, stockSame)
        assertNotEquals(stock.hashCode(), stockSame.hashCode())
    }

    @Test
    fun allFieldCorrectNullCurrencyFields() {
        val stock = Stock("Name",
            "EUR",
            Instant.now().truncatedTo(ChronoUnit.SECONDS))
        val stockSame = Stock("Name",
            null,
            Instant.now().truncatedTo(ChronoUnit.SECONDS))
        assertNotEquals(stock, stockSame)
        assertNotEquals(stock.hashCode(), stockSame.hashCode())
    }

    @Test
    fun allFieldCorrectNullCurrencyFieldsDateNull() {
        val stock = Stock("Name",
            "EUR",
            Instant.now().truncatedTo(ChronoUnit.SECONDS))
        val stockSame = Stock("Name",
            "EUR",
            null)
        assertNotEquals(stock, stockSame)
        assertNotEquals(stock.hashCode(), stockSame.hashCode())
    }

    @Test
    fun allFieldCorrectNullCurrencyFieldsNameNotSame() {
        val stock = Stock("Name1",
            "EUR",
            Instant.now().truncatedTo(ChronoUnit.SECONDS))
        val stockSame = Stock("Name",
            "EUR",
            null)
        assertNotEquals(stock, stockSame)
        assertNotEquals(stock.hashCode(), stockSame.hashCode())
    }



}