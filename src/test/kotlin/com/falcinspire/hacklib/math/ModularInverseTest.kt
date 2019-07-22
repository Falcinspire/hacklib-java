package com.falcinspire.hacklib.math

import org.junit.Assert
import org.junit.Test

class ModularInverseTest {
    @Test
    fun test() {
        Assert.assertEquals(3, coprimeModularInverse(6, 17))
        Assert.assertEquals(3, primeModularInverse(6, 17))
    }
}