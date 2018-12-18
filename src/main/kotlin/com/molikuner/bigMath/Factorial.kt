package com.molikuner.bigMath

import java.math.BigDecimal
import java.math.BigInteger

internal fun BigDecimal.calculateExactFactorial(): BigInteger = this.toBigIntegerExact().calculateFactorial()

internal fun BigDecimal.calculateFactorial(): BigInteger = this.toBigInteger().calculateFactorial()

internal fun BigInteger.calculateFactorial(): BigInteger {
    fun BigInteger.dec() =
            if (this > BigInteger.ZERO) this - BigInteger.ONE else throw IllegalArgumentException("can't calculate faculty of negative numbers")

    return if (this == BigInteger.ONE || this == BigInteger.ZERO) this else this.dec().calculateFactorial() * this
}