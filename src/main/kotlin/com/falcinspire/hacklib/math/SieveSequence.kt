package com.falcinspire.hacklib.math

class SieveSequence(private val array: BooleanArray): Sequence<Int> {
    override fun iterator() = SieveIterator()

    inner class SieveIterator: Iterator<Int> {
        var current = 2 //first prime number
        override fun hasNext(): Boolean {
            while (!array[current]) {
                current++
                if (current == array.size) return false
            }
            return true
        }

        override fun next(): Int {
            while (!array[current]) {
                current++
            }
            val prime = current
            current++
            return prime
        }
    }
}