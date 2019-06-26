package com.falcinspire.hacklib.math

import com.falcinspire.hacklib.math.SieveOfEratosthenesFactor.sieveOfEratosthenes
import org.junit.Assert
import org.junit.Test

class SieveOfEratosthenesFactorTest {

    private val primesLessThan100 = arrayOf(
        2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97
    )

    @Test
    fun match() {
        Assert.assertArrayEquals(
            primesLessThan100,
            sieveOfEratosthenes(100).toList().toTypedArray()
        )
    }
}