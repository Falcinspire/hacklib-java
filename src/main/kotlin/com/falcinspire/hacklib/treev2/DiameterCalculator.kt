package com.falcinspire.hacklib.treev2

import com.falcinspire.hacklib.treev2.dfs.PostOrderDfsListener
import com.falcinspire.hacklib.treev2.dfs.postOrderDfs

class DiameterCalculator {

    fun <T> calculateDiameter(tree: UndirectedIndexedTree<T>): Int {
        val first = calculateHeight(0, tree)
        val second = calculateHeight(first.node, tree)
        return second.height
    }

    fun <T> calculateHeight(start: Int, tree: UndirectedIndexedTree<T>) =
            tree.postOrderDfs(start, object: PostOrderDfsListener<T, Height> {
                override fun makeDefault() = Height(-1, -1)
                override fun reduce(parent: Int, cumulative: Height, nodeB: Int, b: Height) =
                    if (b.height > cumulative.height) {
                        b
                    } else {
                        cumulative
                    }
                override fun merge(nodeA: Int, result: Height) = Height(nodeA, result.height + 1)
            })

    inner class Height(val node: Int, val height: Int)
}