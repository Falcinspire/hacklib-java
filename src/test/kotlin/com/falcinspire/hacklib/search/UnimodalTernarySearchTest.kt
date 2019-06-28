package com.falcinspire.hacklib.search

import org.junit.Test
import com.falcinspire.hacklib.search.UnimodalTernarySearch.ternarySearch

class UnimodalTernarySearchTest {

    @Test
    fun testMinimum() {
        val min = ternarySearch(0f, 50f, Precision(0.00001f), ::fMinimum, minimum = true)
        println("($min, ${fMaximum(min)})")
    }

    @Test
    fun testMaximum() {
        val max = ternarySearch(0f, 50f, Precision(0.00001f), ::fMaximum, minimum = false)
        println("($max, ${fMaximum(max)})")
    }

    private fun fMinimum(x: Float) = (x - 2) * (x - 2) + 4
    private fun fMaximum(x: Float) = -((x - 2) * (x - 2)) + 4
}