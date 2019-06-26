package com.falcinspire.hacklib.combinatorics

import java.util.*

class BitsetCombination(size: Int, private val forSubset: (BitSet) -> Unit):
    CombinationListener {

    val bitset = BitSet(size)

    override fun add(index: Int) {
        bitset[index] = true
    }

    override fun remove(index: Int) {
        bitset[index] = false
    }

    override fun ready() {
        forSubset(bitset)
    }
}