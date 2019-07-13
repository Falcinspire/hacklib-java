package com.falcinspire.hacklib.treev2

class AncesNode(val size: Int) {
    private val ancestors = IntArray(size) {-1}

    fun setAncestor(pow2: Int, node: Int) {
        ancestors[pow2] = node
    }

    fun getAncestor(pow2: Int) = ancestors[pow2]
}