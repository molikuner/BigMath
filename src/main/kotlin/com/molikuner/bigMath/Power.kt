package com.molikuner.bigMath

import java.math.BigDecimal
import java.math.BigInteger
import java.math.RoundingMode

internal fun BigDecimal.calculatePow(y: BigDecimal, accuracy: Int): BigDecimal {
    if (y < BigDecimal.ZERO)
        return BigDecimal.ONE.setScale(accuracy).divide(this.calculatePow(y.abs(), accuracy), RoundingMode.HALF_UP)
    val result = this.integerPow(y.toBigInteger())
    if (Math.max(0, y.stripTrailingZeros().scale()) > 0) {
        val fraction = y.fraction()
        return result * this.root(fraction.dividend, accuracy).integerPow(fraction.divisor)
    } else {
        return result
    }
}

internal fun BigDecimal.integerPow(y: BigInteger): BigDecimal {
    if (this == BigDecimal.ZERO) {
        return if (y == BigInteger.ZERO)
            throw ArithmeticException("0^0 is not defined")
        else
            BigDecimal.ZERO
    }
    return BigDecimal.ONE.pow(this, y)
}

private fun BigDecimal.pow(x: BigDecimal, y: BigInteger): BigDecimal {
    return if (y > BigInteger.ZERO) {
        this * x.pow(x, y - BigInteger.ONE)
    } else this
}