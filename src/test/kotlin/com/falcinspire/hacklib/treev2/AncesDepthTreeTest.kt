package com.falcinspire.hacklib.treev2

import org.junit.Test

class AncesDepthTreeTest {
    @Test
    fun test() {
        val tree = AncesDepthTree(9)

        tree.connect(0, 1)
        tree.connect(1, 5)
        tree.connect(0, 2)
        tree.connect(0, 3)
        tree.connect(3, 6)
        tree.connect(3, 7)
        tree.connect(3, 8)
        tree.connect(0, 4)

        tree.dp()
        println(tree.lowestCommonAncestor(6, 8))
        println(tree.distance(6, 8))
        println(tree.lowestCommonAncestor(5, 6))
        println(tree.distance(5, 6))
        println(tree.lowestCommonAncestor(3, 5))
        println(tree.distance(3, 5))
    }
}