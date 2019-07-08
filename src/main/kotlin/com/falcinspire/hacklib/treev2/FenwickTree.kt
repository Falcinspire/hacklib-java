package com.falcinspire.hacklib.treev2

import com.falcinspire.hacklib.math.addSmallestPow2
import com.falcinspire.hacklib.math.subtractSmallestPow2

/**
 * Efficiently update elements and calculate prefix sums in a table of numbers - Wikipedia
 */
class FenwickTree(inputSize: Int) {
    val size = inputSize + 1
    val array = IntArray(size)

    fun update(index: Int, change: Int) {
        var thisIndex = index + 1
        while (thisIndex < size) {
            array[thisIndex] += change
            thisIndex = addSmallestPow2(thisIndex)
        }
    }

    fun sum(end: Int): Int {
        var sum = 0
        var thisIndex = end + 1
        while (thisIndex > 0) {
            sum += array[thisIndex]
            thisIndex = subtractSmallestPow2(thisIndex)
        }
        return sum
    }
}

fun FenwickTree.range(start: Int, end: Int): Int {
    if (start == 0) return sum(end)
    else return sum(end) - sum(start - 1)
}