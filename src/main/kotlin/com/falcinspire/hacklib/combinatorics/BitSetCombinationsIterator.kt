package com.falcinspire.hacklib.combinatorics

import java.util.*

class BitSetCombinationsIterator(val size: Int, val subsetSize: Int): Iterator<BitSet> {
    private val bitSet = BitSet(size)
    private val stack = Stack<Int>()

    init {
        stack.push(size)
        for (i in (subsetSize - 1) downTo 0) {
            bitSet[i] = true
            stack.push(i)
        }
    }

    private var notFinished = true

    private val OVERFLOW = true

    override fun hasNext() = notFinished

    override fun next(): BitSet {
        val current = bitSet.clone() as BitSet
        notFinished = nextCombination()
        return current
    }

    private fun nextCombination(): Boolean {
        bumpLast()
        if (fixCollisions() == OVERFLOW)
            return false
        refill()
        return true
    }

    private fun bumpLast() {
        val location = stack.pop()
        bitSet[location] = false

        stack.push(location + 1)
        bitSet[location + 1] = true
    }

    private fun refill() {
        var stackSize = stack.size - 1 // root element
        while (stackSize < subsetSize) {
            stack.push(subsetSize - stackSize - 1)
            bitSet[subsetSize - stackSize - 1] = true
            stackSize++
        }
    }

    private fun fixCollisions(): Boolean {
        while(true) {
            val top = stack.pop()
            val second = stack.peek()
            if (top == second) {
                // will be pushed outside set?
                if (second + 1 == size) return OVERFLOW
                bumpLast()
            } else {
                stack.push(top)
                break
            }
        }
        return false
    }
}
