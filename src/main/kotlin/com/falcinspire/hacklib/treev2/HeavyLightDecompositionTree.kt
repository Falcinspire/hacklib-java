package com.falcinspire.hacklib.treev2

import com.falcinspire.hacklib.treev2.dfs.PostOrderDfsListener
import com.falcinspire.hacklib.treev2.dfs.postOrderDfs

class HeavyLightDecompositionTree(val size: Int) {
    private val tree = createUndirectedIndexedTree(size) {SizeNode()}

    fun connect(a: Int, b: Int) {
        tree.connect(a, b)
    }

    fun dp() {
        tree.postOrderDfs(0, object: PostOrderDfsListener<SizeNode, Int> {
            override fun makeDefault() = 0
            override fun reduce(parent: Int, cumulative: Int, nodeB: Int, b: Int) = cumulative + b
            override fun merge(nodeA: Int, result: Int): Int {
                tree.value(nodeA).size = result + 1
                return tree.value(nodeA).size
            }
        })
    }

    fun makePaths(): MutableList<ArrayList<Int>> {
        val lists = mutableListOf<ArrayList<Int>>()
        val list = ArrayList<Int>()
        lists.add(list)
        recurse(0, -1, list, lists)
        return lists
    }

    fun recurse(node: Int, parent: Int, current: ArrayList<Int>, lists: MutableList<ArrayList<Int>>) {
        current.add(node)

        var biggest = -1
        var biggestSize = 0
        for (child in tree.children(node)) {
            if (child == parent) continue

            if (tree.value(child).size > biggestSize) {
                biggest = child
                biggestSize = tree.value(child).size
            }
        }

        if (biggest != -1) {
            recurse(biggest, node, current, lists)
        }

        for (child in tree.children(node)) {
            if (child == parent) continue
            if (child == biggest) continue

            val list = ArrayList<Int>()
            lists.add(list)
            recurse(child, node, list, lists)
        }
    }
}