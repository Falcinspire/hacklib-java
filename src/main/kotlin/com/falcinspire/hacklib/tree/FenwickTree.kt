package com.falcinspire.hacklib.tree
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
            thisIndex = addRightmostBit(thisIndex)
        }
    }

    fun getSum(end: Int): Int {
        var sum = 0
        var thisIndex = end + 1
        while (thisIndex > 0) {
            sum += array[thisIndex]
            thisIndex = subtractRightmostBit(thisIndex)
        }
        return sum
    }

    fun range(start: Int, end: Int): Int {
        if (start == 0) return getSum(end)
        else return getSum(end) - getSum(start - 1)
    }
}