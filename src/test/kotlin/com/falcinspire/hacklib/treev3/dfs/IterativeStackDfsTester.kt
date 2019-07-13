package com.falcinspire.hacklib.treev3.dfs

import com.falcinspire.hacklib.treev2.createUndirectedIndexedTree
import org.junit.Test

class IterativeStackDfsTester {
    @Test
    fun manualStackDfs() {
        val tree = createUndirectedIndexedTree(7) {}
        tree.connect(0, 1)
        tree.connect(0, 2)
        tree.connect(0, 3)
        tree.connect(2, 4)
        tree.connect(4, 5)
        for (node in IterativeStackDfs(tree)) {
            println(node)
        }
    }
}