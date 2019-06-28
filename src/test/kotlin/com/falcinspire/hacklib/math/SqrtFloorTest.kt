package com.falcinspire.hacklib.math

import org.junit.Assert
import org.junit.Test
import kotlin.math.sqrt

class SqrtFloorTest {
    @Test
    fun testSqrts() {
        repeat(1000) {
            Assert.assertEquals(
                sqrt(it.toDouble()).toInt(),
                sqrtFloor(it)
            )
        }
    }
}