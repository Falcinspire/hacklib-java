package com.falcinspire.hacklib.search

import com.falcinspire.hacklib.search.ComparisonResult.*

object BinarySearchFloor {
    fun binarySearch(low: Int, high: Int, compare: (Int) -> ComparisonResult): Int {
        var lower = low
        var upper = high

        var answer = 0

        loop@ while (lower <= upper) {
            val mid = (lower + upper) / 2
            val result = compare(mid)
            when (result) {
                EQUAL -> {
                    answer = mid
                    break@loop
                }
                LESS -> {
                    answer = mid
                    lower = mid + 1
                }
                GREATER -> {
                    upper = mid - 1
                }
            }
        }
        return answer
    }

    private inline fun isEqual(result: Int) = result == 0
    private inline fun isGreater(result: Int) = result > 0
    private inline fun isLess(result: Int) = result < 0
}