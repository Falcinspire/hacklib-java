package com.falcinspire.hacklib.tree

import org.junit.Test

class FenwickTreeTest {
    @Test
    fun fenwick() {
        val array = intArrayOf(3, 2, -1, 6, 5, 4, -3, 3, 7, 2, 3)
        val fenwick = FenwickTree(array.size)
        array.forEachIndexed { i, it -> fenwick.pointUpdate(i, it) }
        repeat(array.size + 1) {
            print("${fenwick.array[it]} ")
        }
        println()
        fenwick.pointUpdate(6, 3)
        repeat(array.size + 1) {
            print("${fenwick.array[it]} ")
        }
        println()
    }
}