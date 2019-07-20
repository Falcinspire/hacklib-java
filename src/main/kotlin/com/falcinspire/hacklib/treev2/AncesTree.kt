package com.falcinspire.hacklib.treev2

import com.falcinspire.hacklib.math.log2floor
import com.falcinspire.hacklib.math.pow2
import com.falcinspire.hacklib.treev2.dfs.PreOrderDfsListener
import com.falcinspire.hacklib.treev2.dfs.preOrderDfs

class AncesTree(val size: Int) {
    private val depth = log2floor(size)
    private val tree = createUndirectedIndexedTree(size) {AncesNode(depth + 1)}

    fun dp() {
        // base case
        tree.preOrderDfs(0, object: PreOrderDfsListener<AncesNode, Int> {
            override fun makeDefault() = -1
            override fun merge(node: Int, parent: Int, result: Int): Int {
                setAncestor(node, 0, result)
                return node
            }
        })

        // k through depth
        for (k in 1..depth) {
            tree.preOrderDfs(0, object: PreOrderDfsListener<AncesNode, Unit> {
                override fun makeDefault() {}
                override fun merge(node: Int, parent: Int, result: Unit) {
                    val halfway = getAncestor(node, k - 1)
                    if (halfway != -1)
                        setAncestor(node, k, getAncestor(halfway, k - 1))
                }
            })
        }
    }

    private fun getAncestor(node: Int, pow2: Int) = tree.value(node).getAncestor(pow2)
    private fun setAncestor(node: Int, pow2: Int, value: Int) {
        tree.value(node).setAncestor(pow2, value)
    }

    fun calculateAncestor(node: Int, n: Int): Int {
        var current = node
        var jumper = n
        while (jumper > 0) {
            val jump = log2floor(n)
            current = getAncestor(current, jump)
            if (current == -1) return -1
            jumper -= pow2(jump)
        }
        return current
    }
}