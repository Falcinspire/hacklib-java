package com.falcinspire.hacklib.math

fun pow2Cieling(n: Int): Int {
    val floor = log2floor(n)
    return if (n == pow2(floor))
        n
    else
        pow2(floor + 1)
}