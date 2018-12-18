package com.molikuner.bigMath

import java.math.BigDecimal
import java.math.BigInteger

fun BigInteger.factorial(): BigInteger {
    return this.calculateFactorial()
}

fun BigInteger.fraction(): Fraction {
    return this to BigInteger.ONE
}

fun BigInteger.pow(y: BigDecimal, accuracy: Int = DEFAULT_ACCURACY): BigDecimal {
    return this.toBigDecimal().calculatePow(y, accuracy)
}

fun BigInteger.pow(y: BigInteger, accuracy: Int = DEFAULT_ACCURACY): BigDecimal {
    return this.toBigDecimal().calculatePow(y.toBigDecimal(), accuracy)
}

fun BigInteger.root(n: BigInteger, accuracy: Int = DEFAULT_ACCURACY, maxIterations: Int = DEFAULT_MAX_ITERATIONS): BigDecimal {
    return this.toBigDecimal().calculateRoot(n, accuracy, maxIterations)
}

fun BigInteger.sqrt(accuracy: Int = DEFAULT_ACCURACY, maxIterations: Int = DEFAULT_MAX_ITERATIONS): BigDecimal {
    return this.root(BigInteger.valueOf(2), accuracy, maxIterations)
}

fun BigInteger.cbrt(accuracy: Int = DEFAULT_ACCURACY, maxIterations: Int = DEFAULT_MAX_ITERATIONS): BigDecimal {
    return this.root(BigInteger.valueOf(3), accuracy, maxIterations)
}
