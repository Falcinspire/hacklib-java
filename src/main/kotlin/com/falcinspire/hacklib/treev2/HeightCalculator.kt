package com.falcinspire.hacklib.treev2

import com.falcinspire.hacklib.treev2.dfs.PostOrderDfsListener
import com.falcinspire.hacklib.treev2.dfs.postOrderDfs
import java.lang.Integer.max

class HeightCalculator {
    fun <T> calculateHeight(tree: UndirectedIndexedTree<T>): Int =
            tree.postOrderDfs(0, object: PostOrderDfsListener<T, Int> {
                override fun makeDefault()
                        = -1
                override fun reduce(nodeA: Int, a: Int, nodeB: Int, b: Int)
                        = max(a, b)
                override fun merge(nodeA: Int, result: Int)
                        = result + 1
            })

}