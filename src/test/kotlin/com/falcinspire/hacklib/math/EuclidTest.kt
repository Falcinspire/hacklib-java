package com.falcinspire.hacklib.math

import org.junit.Assert
import org.junit.Test

class EuclidTest {
    @Test
    fun test() {
        Assert.assertEquals(7, euclid(21, 49))
        Assert.assertEquals(7, euclid(49, 21))
        Assert.assertEquals(1, euclid(1, 1))
        Assert.assertEquals(3, euclid(102, 39))
    }
}