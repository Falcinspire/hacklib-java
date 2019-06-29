package com.falcinspire.hacklib.tree

import org.junit.Assert
import org.junit.Test
import java.lang.Integer.min

class SegmentTreeTester {

    @Test
    fun sum() {
        val array = intArrayOf(1, 2, 3, 4, 5)
        val segmentTree = SegmentTree.build(array, SegmentTree.SUM)
        println(segmentTree.size)

        for (i in 0 until array.size) {
            for (j in i until array.size) {
                val a = segmentTree.range(i, j)
                val b = bruteForceSum(i, j, array)
                println("$i-$j query: $a | brute: $b ")
                Assert.assertEquals(a, b)
            }
        }

        array[1] = 7
        segmentTree.update(1, 7)

        println("Updating")

        for (i in 0 until array.size) {
            for (j in i until array.size) {
                val a = segmentTree.range(i, j)
                val b = bruteForceSum(i, j, array)
                println("$i-$j query: $a | brute: $b ")
                Assert.assertEquals(a, b)
            }
        }
    }

    private fun bruteForceSum(start: Int, end: Int, array: IntArray): Int {
        var sum = 0
        var cursor = start
        while (cursor <= end) {
            sum += array[cursor]
            cursor++
        }
        return sum
    }

    @Test
    fun min() {
        val array = intArrayOf(1, 2, 3, 4, 5)
        val segmentTree = SegmentTree.build(array, SegmentTree.MIN)
        println(segmentTree.size)
        BinaryArrayTreePrinter().print(segmentTree.tree)

        for (i in 0 until array.size) {
            for (j in i until array.size) {
                val a = segmentTree.range(i, j)
                val b = bruteForceMin(i, j, array)
                println("$i-$j query: $a | brute: $b ")
                Assert.assertEquals(a, b)
            }
        }

        array[1] = 7
        segmentTree.update(1, 7)

        println("Updating")

        for (i in 0 until array.size) {
            for (j in i until array.size) {
                val a = segmentTree.range(i, j)
                val b = bruteForceMin(i, j, array)
                println("$i-$j query: $a | brute: $b ")
                Assert.assertEquals(a, b)
            }
        }
    }

    private fun bruteForceMin(start: Int, end: Int, array: IntArray): Int {
        var min = Int.MAX_VALUE
        var cursor = start
        while (cursor <= end) {
            min = min(min, array[cursor])
            cursor++
        }
        return min
    }

    @Test
    fun showOffToChris() {
        val array = intArrayOf(1, 2, 3, 4, 5, 6)
        val querySum = SegmentTree.build(array, SegmentTree.SUM)
        val queryMin = SegmentTree.build(array, SegmentTree.MIN)
        val queryMax = SegmentTree.build(array, SegmentTree.MAX)
    }
}