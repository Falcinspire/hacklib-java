package com.falcinspire.hacklib.math

import java.lang.Math.sqrt

object SieveOfEratosthenesFactor {
    fun sieveOfEratosthenes(n: Int): Sequence<Int> {
        val possiblePrimes = BooleanArray(n) {true}
        val nSqrt = sqrt(n.toDouble()).toInt() //TODO integer version
        for (i in 2..nSqrt) {
            if (possiblePrimes[i]) {
                var multiplier = 2
                var makeComposite = i * multiplier
                while (makeComposite < n) {
                    possiblePrimes[makeComposite] = false
                    multiplier++
                    makeComposite = i * multiplier
                }
            }
        }
        return SieveSequence(possiblePrimes)
    }
}