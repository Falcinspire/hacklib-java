package com.falcinspire.hacklib.collection

import org.junit.Test

class MinimumRangeTest {
    @Test
    fun test() {
        val minrange = MinimumRange.create(intArrayOf(2, 4, 32, 10, 6, 7, 8, 9, 2, 7))
        println(minrange[1, 8])
    }
}