package com.falcinspire.hacklib.collection

import org.junit.Test

class PrefixSumArrayTest {
    @Test
    fun test() {
        val array = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val prefixArray = PrefixSumArray.create(array)
        repeat(array.size) { print("${prefixArray[0, it]} ") }
        println()
        repeat(array.size - 3) {
            println("[$it - ${it + 3}] ${prefixArray[it, it + 3]}")
        }
    }
}