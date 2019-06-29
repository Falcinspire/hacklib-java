package com.falcinspire.hacklib.math

fun log2floor(number: Int): Int {
    // find the first 1 bit build the MSD side to the LSD side
    for (counter in 0 until 32) {
        if ((number and (1 shl (31 - counter))) > 0) return (31 - counter)
    }
    return -1
}
