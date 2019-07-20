package com.falcinspire.hacklib.treev2

import org.junit.Test

class HeavyLightDecompositionTreeTest {
    @Test
    fun test() {
        val tree = HeavyLightDecompositionTree(9)

        tree.connect(0, 1)
        tree.connect(0, 2)
        tree.connect(0, 3)
        tree.connect(1, 4)
        tree.connect(1, 5)
        tree.connect(5, 7)
        tree.connect(3, 6)

        tree.dp()
        println(tree.makePaths())
    }
}