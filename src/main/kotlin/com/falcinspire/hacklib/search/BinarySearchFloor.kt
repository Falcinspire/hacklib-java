package com.falcinspire.hacklib.search

object BinarySearchFloor {
    fun binarySearch(low: Int, high: Int, compare: (Int) -> Int): Int {
        var lower = low
        var upper = high

        var answer = 0

        loop@ while (lower <= upper) {
            val mid = (lower + upper) / 2
            val result = compare(mid)
            when {
                isEqual(result) -> {
                    answer = mid
                    break@loop
                }
                isLess(result) -> {
                    answer = mid
                    lower = mid + 1
                }
                isGreater(result) -> {
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