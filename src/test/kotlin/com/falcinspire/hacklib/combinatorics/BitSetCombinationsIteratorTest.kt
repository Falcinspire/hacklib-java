package com.falcinspire.hacklib.combinatorics

import org.junit.Test

class BitSetCombinationsIteratorTest {
    @Test
    fun test() {
        for (comb in BitSetCombinationsIterator(6, 3)) {
            println(comb)
        }
    }
}