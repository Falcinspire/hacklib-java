package com.falcinspire.hacklib.tree

import org.junit.Test

class DiameterDFSTest {
    @Test
    fun test() {
        val tree = DiameterDFSTree(7)
        DiameterTreeSampleBuilder().build(DiameterDFSTreeBuilder(tree))
        println(tree.diameter())
    }
}