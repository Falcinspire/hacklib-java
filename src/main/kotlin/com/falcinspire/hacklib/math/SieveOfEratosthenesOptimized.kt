package com.falcinspire.hacklib.math

import java.lang.Math.sqrt

object SieveOfEratosthenesOptimized {
    fun sieveOfEratosthenes(n: Int): List<Int> {
        val possiblePrimes = BooleanArray(n) {true}
        val nSqrt = sqrt(n.toDouble()).toInt() //TODO integer version
        for (i in 2..nSqrt) {
            if (possiblePrimes[i]) {
                var makeComposite = i * i
                while (makeComposite < n) {
                    possiblePrimes[makeComposite] = false
                    makeComposite += i
                }
            }
        }
        val list = ArrayList<Int>()
        for (i in 0 until n) {
            if (possiblePrimes[i])
                list.add(i)
        }
        return list
    }
}