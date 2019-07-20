package com.falcinspire.hacklib.treev2

import com.falcinspire.hacklib.treev2.dfs.PreOrderDfsListener
import com.falcinspire.hacklib.treev2.dfs.preOrderDfs
import org.junit.Test

class CentroidDecompositionTreeTest {
    @Test
    fun test() {
        val tree = CentroidDecompositionTree(16)

        tree.connect(5, 4)
        tree.connect(5, 6)
        tree.connect(5, 9)
        tree.connect(6, 7)
        tree.connect(6, 8)
        tree.connect(9, 10)
        tree.connect(10, 11)
        tree.connect(11, 13)
        tree.connect(10, 12)
        tree.connect(12, 14)
        tree.connect(12, 15)
        tree.connect(4, 3)
        tree.connect(3, 0)
        tree.connect(3, 1)
        tree.connect(3, 2)

        val root = tree.decompose()
        tree.decomposition.preOrderDfs(root, object: PreOrderDfsListener<Unit, Unit> {
            override fun makeDefault() {}
            override fun merge(node: Int, parent: Int, result: Unit) {
                println(node)
            }
        })
    }
}