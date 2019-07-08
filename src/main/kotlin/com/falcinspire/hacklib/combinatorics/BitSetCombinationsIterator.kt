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

    override fun hasNext() = notFinished

    override fun next(): BitSet {
        val current = bitSet.clone() as BitSet
        notFinished = nextCombination()
        return current
    }

    private fun nextCombination(): Boolean {
        bumpLastLeft()

        while(true) {
            val top = stack.pop()
            val second = stack.pop()
            if (top == second) {
                // throw out top

                // pushed outside set?
                if (second + 1 == size) return /* Finished */ false

                bitSet[top] = false

                // move leftmost one left
                stack.push(second + 1)
                bitSet[second + 1] = true

            } else {
                stack.push(second)
                stack.push(top)
                break
            }
        }

        var stackSize = stack.size - 1 // root element
        while (stackSize < subsetSize) {
            stack.push(subsetSize - stackSize - 1)
            bitSet[subsetSize - stackSize - 1] = true
            stackSize++
        }

        return /* Not finished */ true
    }

    private fun bumpLastLeft() {
        val location = stack.pop()
        bitSet[location] = false

        stack.push(location + 1)
        bitSet[location + 1] = true
    }
}
