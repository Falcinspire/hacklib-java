package com.falcinspire.hacklib.treev2

import com.falcinspire.hacklib.treev2.dfs.PostOrderDfsListener
import com.falcinspire.hacklib.treev2.dfs.PreOrderDfsListener
import com.falcinspire.hacklib.treev2.dfs.postOrderDfs
import com.falcinspire.hacklib.treev2.dfs.preOrderDfs

class SumPathTree(val size: Int) {
    private val tree = createUndirectedIndexedTree(size){ValueNode()}
    private val table = SumPathTable(size)

    fun connect(a: Int, b: Int) = tree.connect(a, b)
    fun value(node: Int, value: Int) {
        tree.value(node).value = value
    }

    fun dp() {
        var dfsIndex = 0
        tree.preOrderDfs(0, object: PreOrderDfsListener<ValueNode, Int> {
            override fun makeDefault() = 0
            override fun merge(node: Int, parent: Int, result: Int): Int {
                table.setOrder(node, dfsIndex)
                val path = result + tree.value(node).value
                table.setPath(dfsIndex, path)
                dfsIndex++
                return path
            }
        })
        tree.postOrderDfs(0, object: PostOrderDfsListener<ValueNode, Int> {
            override fun makeDefault() = 0
            override fun reduce(parent: Int, cumulative: Int, nodeB: Int, b: Int) = cumulative + b
            override fun merge(nodeA: Int, result: Int): Int {
                val dfsIndex = table.getOrder(nodeA)
                table.setSize(dfsIndex, result + 1)
                return table.getSize(dfsIndex)
            }
        })
        table.buildDifferenceArray()
    }

    fun printTable() {
        table.print()
    }

    fun update(node: Int, change: Int) {
        val order = table.getOrder(node)
        val size = table.getSize(order)
        table.updateRange(order, order + size - 1, change)
    }

    fun pathSum(node: Int) = table.value(table.getOrder(node))

}