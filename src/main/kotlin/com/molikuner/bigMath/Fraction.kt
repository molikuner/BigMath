package com.molikuner.bigMath

import java.math.BigDecimal
import java.math.BigInteger
import java.math.RoundingMode

typealias Fraction = Pair<BigInteger, BigInteger>

internal fun BigDecimal.calculateFraction(accuracy: Int): Fraction {
    var appliedFraction = Fraction(BigInteger.ONE, BigInteger.ONE)
    while (true) {
        val df = appliedFraction.dividend.toBigDecimal().divide(appliedFraction.divisor.toBigDecimal(), accuracy * 10, RoundingMode.HALF_UP)
        appliedFraction = when {
            df < this -> appliedFraction.copy(dividend = appliedFraction.dividend + BigInteger.ONE)
            df > this -> appliedFraction.copy(
                    dividend = this.multiply(appliedFraction.divisor.toBigDecimal()).setScale(0, RoundingMode.HALF_UP).toBigInteger(),
                    divisor = appliedFraction.divisor + BigInteger.ONE
            )
            else -> return appliedFraction
        }
    }
}

val Fraction.dividend: BigInteger
    get() = this.first

val Fraction.divisor: BigInteger
    get() = this.second

@Suppress("EXTENSION_SHADOWED_BY_MEMBER") // want to have the names
fun Fraction.copy(dividend: BigInteger = this.dividend, divisor: BigInteger = this.divisor) = this.copy(dividend, divisor)
