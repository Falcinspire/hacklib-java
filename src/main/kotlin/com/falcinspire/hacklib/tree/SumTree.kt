package com.falcinspire.hacklib.tree

import com.falcinspire.hacklib.util.MutableInt

/* Calculates sums of subtrees using a backing Fenwick tree */
class SumTree(val size: Int) {

    private val nodes = Array(size) { SumTreeNode() }
    private val dfs = IntArray(size) {-1}
    private val treeSizes = IntArray(size) {-1}
    private val fenwickTree = FenwickTree(size)

    fun connect(a: Int, b: Int) {
        nodes[a].children.add(b)
        nodes[b].children.add(a)
    }

    fun setWeight(a: Int, weight: Int) {
        nodes[a].weight = weight
    }

    fun dfs(parent: Int, node: Int, cursor: MutableInt) {
        dfs[cursor.value] = node
        cursor.value++

        for (child in nodes[node].children) {
            if (child == parent) continue

            dfs(node, child, cursor)
        }
    }

    fun markTreeSizes() {
        markTreeSize(0, 0)
    }

    fun markTreeSize(parent: Int, node: Int) {
        val children = nodes[node].children
        treeSizes[node] = children.size

        for (child in children) {
            if (child == parent) continue

            markTreeSize(node, child)
        }

    }

    fun markSums() {
        repeat(size) {
            val node = dfs[it]
            fenwickTree.update(node, nodes[node].weight)
        }
    }

    fun dp() {
        dfs(0, 0, MutableInt())
        markTreeSizes()
        markSums()
    }

    fun sum(node: Int) = fenwickTree.range(node, node + treeSizes[node] - 1)

}