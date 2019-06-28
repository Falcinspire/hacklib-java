package com.falcinspire.hacklib.math

fun printBinary(n: Int) {
    repeat(32) {
        print((n shr (31 - it)) and 1)
    }
    println()
}