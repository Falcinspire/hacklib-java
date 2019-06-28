package com.falcinspire.hacklib.tree

import org.junit.Test

class DiameterDPTest {
    @Test
    fun test() {
        val tree = DiameterDPTree(7)
        DiameterTreeSampleBuilder().build(DiameterDPTreeBuilder(tree))
        tree.setupDp()
        println(tree.diameter())
    }
}