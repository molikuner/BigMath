package com.molikuner.bigMath

import java.math.BigDecimal
import java.math.BigInteger

typealias Fraction = Pair<BigInteger, BigInteger>

internal fun BigDecimal.calculateFraction() = Fraction(BigInteger.ONE, BigInteger.ONE).apply(this)

val Fraction.dividend: BigInteger
    get() = this.first

val Fraction.divisor: BigInteger
    get() = this.second

@Suppress("EXTENSION_SHADOWED_BY_MEMBER") // want to have the names
fun Fraction.copy(dividend: BigInteger = this.dividend, divisor: BigInteger = this.divisor) = this.copy(dividend, divisor)

private fun Fraction.apply(x: BigDecimal, df: BigDecimal = this.dividend.toBigDecimal() / this.divisor.toBigDecimal()): Fraction {
    return when {
        df < x -> this.copy(dividend = this.dividend + BigInteger.ONE).apply(x)
        df > x -> this.copy(
                divisor = this.divisor + BigInteger.ONE,
                dividend = x.multiply(BigDecimal(this.divisor)).toBigInteger()
        ).apply(x)
        else -> this
    }
}
