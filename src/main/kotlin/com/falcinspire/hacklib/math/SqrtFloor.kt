package com.falcinspire.hacklib.math

import com.falcinspire.hacklib.search.BinarySearchFloor.binarySearch

fun sqrtFloor(n: Int): Int {
    if (n == 0 || n == 1) return n

    return binarySearch(0, n / 2) { (it * it) - n }
}