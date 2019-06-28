package com.falcinspire.hacklib.search

import org.junit.Test
import com.falcinspire.hacklib.search.UnimodalTernarySearch.ternarySearch

class UnimodalTernarySearchTest {

    @Test
    fun testMinimum() {
        val min = ternarySearch(0.0, 50.0, Precision(0.0001), ::fMinimum, minimum = true)
        println("($min, ${fMaximum(min)})")
    }

    @Test
    fun testMaximum() {
        val max = ternarySearch(0.0, 50.0, Precision(0.0001), ::fMaximum, minimum = false)
        println("($max, ${fMaximum(max)})")
    }

    private fun fMinimum(x: Double) = (x - 2) * (x - 2) + 4
    private fun fMaximum(x: Double) = -((x - 2) * (x - 2)) + 4
}