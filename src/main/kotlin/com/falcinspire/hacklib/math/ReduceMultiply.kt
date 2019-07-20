package com.falcinspire.hacklib.math

// copied from Kotlin std and modified
inline fun <T: Int> Iterable<T>.multiply(): Int {
    val iterator = this.iterator()
    if (!iterator.hasNext()) throw UnsupportedOperationException("Empty collection can't be reduced.")
    var accumulator: Int = iterator.next()
    while (iterator.hasNext()) {
        accumulator *= iterator.next()
    }
    return accumulator
}