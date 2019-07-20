package com.falcinspire.hacklib.math

import java.lang.Math.sqrt

object SieveOfEratosthenesOptimized {
    fun sieveOfEratosthenes(n: Int): Sequence<Int> {
        val possiblePrimes = BooleanArray(n) {true}
        val nSqrt = sqrtFloor(n)
        for (i in 2..nSqrt) {
            if (possiblePrimes[i]) {
                var makeComposite = i * i
                while (makeComposite < n) {
                    possiblePrimes[makeComposite] = false
                    makeComposite += i
                }
            }
        }
        return SieveSequence(possiblePrimes)
    }
}