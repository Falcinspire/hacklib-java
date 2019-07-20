package com.falcinspire.hacklib.math

import org.junit.Assert
import org.junit.Test

class EuclidExtendedTest {
    @Test
    fun test() {
        verifySelf(273, 165)
    }

    private fun verifySelf(a: Int, b: Int) {
        val result = euclidExtended(a, b)
        println("${result.gcd} = $a*${result.s} + $b*${result.t}")
        println("${result.gcd} = ${a * result.s + b * result.t}")
    }
}