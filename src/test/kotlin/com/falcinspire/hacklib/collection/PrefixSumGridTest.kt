package com.falcinspire.hacklib.collection

import org.junit.Test

class PrefixSumGridTest {
    @Test
    fun test() {
        val array = arrayOf(
            intArrayOf(10, 20, 30),
            intArrayOf(5, 10, 20),
            intArrayOf(2, 4, 6)
        )
        val prefixGrid = PrefixSumGrid.create(array)
        println(prefixGrid.sum(x1=1, y1=1, x2=2, y2=2))
    }
}