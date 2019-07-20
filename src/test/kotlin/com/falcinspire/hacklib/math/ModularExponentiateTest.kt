package com.falcinspire.hacklib.math

import org.junit.Assert
import org.junit.Test

class ModularExponentiateTest {
    @Test
    fun test() {
        Assert.assertEquals(32, modularExponentiate(2, 5))
        Assert.assertEquals(27, modularExponentiate(3, 3))
        Assert.assertEquals(1, modularExponentiate(5, 117, 19))
    }
}