package com.falcinspire.hacklib.math

import com.falcinspire.hacklib.search.BinarySearchFloor.binarySearch
import com.falcinspire.hacklib.search.ComparisonResult.*

fun sqrtFloor(n: Int): Int {
    if (n == 0 || n == 1) return n

    return binarySearch(0, n / 2) {
        val diff = (it * it) - n
        when {
            diff > 0 -> GREATER
            diff < 0 -> LESS
            else -> EQUAL
        }
    }
}