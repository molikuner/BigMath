package com.molikuner.bigMath

import java.math.BigDecimal
import java.math.BigInteger

internal const val DEFAULT_ACCURACY = 100
internal const val DEFAULT_MAX_ITERATIONS = 2000000

fun BigDecimal.factorial(): BigInteger {
    return this.calculateExactFactorial()
}

fun BigDecimal.factorialSave(): BigInteger {
    return this.calculateFactorial()
}

fun BigDecimal.fraction(accuracy: Int = DEFAULT_ACCURACY): Fraction {
    return this.calculateFraction(accuracy)
}

fun BigDecimal.pow(y: BigDecimal, accuracy: Int = DEFAULT_ACCURACY): BigDecimal {
    return this.calculatePow(y, accuracy)
}

fun BigDecimal.pow(y: BigInteger, accuracy: Int = DEFAULT_ACCURACY): BigDecimal {
    return this.calculatePow(y.toBigDecimal(), accuracy)
}

fun BigDecimal.root(n: BigInteger, accuracy: Int = DEFAULT_ACCURACY, maxIterations: Int = DEFAULT_MAX_ITERATIONS): BigDecimal {
    return this.calculateRoot(n, accuracy, maxIterations)
}

fun BigDecimal.sqrt(accuracy: Int = DEFAULT_ACCURACY, maxIterations: Int = DEFAULT_MAX_ITERATIONS): BigDecimal {
    return this.root(BigInteger.valueOf(2), accuracy, maxIterations)
}

fun BigDecimal.cbrt(accuracy: Int = DEFAULT_ACCURACY, maxIterations: Int = DEFAULT_MAX_ITERATIONS): BigDecimal {
    return this.root(BigInteger.valueOf(3), accuracy, maxIterations)
}
