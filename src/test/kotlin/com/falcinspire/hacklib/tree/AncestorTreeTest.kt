package com.falcinspire.hacklib.tree

import org.junit.Test

class AncestorTreeTest {
    @Test
    fun test() {
        val tree = AncestorTree(9)
        tree.connect(0, 1)
        tree.connect(0, 3)
        tree.connect(0, 4)
        tree.connect(1, 5)
        tree.connect(3, 2)
        tree.connect(3, 6)
        tree.connect(6, 7)
        tree.connect(7, 8)
        tree.dp()
        repeat(tree.ancestors.size) { i ->
            print("#$i ")
            repeat(tree.ancestors[0].size) { j ->
                print("${tree.ancestors[i][j]} ")
            }
            println()
        }
        println(tree.calculateAncestor(8, 3))
    }
}