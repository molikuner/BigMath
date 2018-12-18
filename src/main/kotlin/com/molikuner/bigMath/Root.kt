package com.molikuner.bigMath

import java.math.BigDecimal
import java.math.BigInteger
import java.math.RoundingMode

internal fun BigDecimal.calculateRoot(n: BigInteger, accuracy: Int, maxIterations: Int): BigDecimal {
    if (this < BigDecimal.ZERO) throw ArithmeticException("can't calculate roots of negative numbers")
    if (n <= BigInteger.ONE) throw ArithmeticException("can't calculate n'th root where n is smaller than two")

    val tolerance = BigDecimal(Math.pow(10.0, -accuracy.toDouble()))

    val nthRoot = this.setScale(accuracy, RoundingMode.HALF_UP)
            .divide(n.toBigDecimal(), RoundingMode.HALF_UP)
            .guessOfIt(this, n, tolerance, maxIterations)

    if (nthRoot.f(this, n).abs() <= tolerance) {
        return nthRoot.setScale(accuracy, RoundingMode.DOWN)
    } else throw ArithmeticException("could not find root with given accuracy after $maxIterations iterations")
}

private fun BigDecimal.guessOfIt(x: BigDecimal, n: BigInteger, tolerance: BigDecimal, iterationsLeft: Int): BigDecimal {
    return if (iterationsLeft > 0 && this.f(x, n).abs() > tolerance) {
        this.subtract(this.f(x, n).divide(this.fPrime(n), RoundingMode.HALF_UP))
                .guessOfIt(x, n, tolerance, iterationsLeft.dec())
    } else {
        this
    }
}

private fun BigDecimal.f(x: BigDecimal, n: BigInteger): BigDecimal {
    return this.pow(n) - x
}

private fun BigDecimal.fPrime(n: BigInteger): BigDecimal {
    return this.pow(n - BigInteger.ONE) * n.toBigDecimal()
}