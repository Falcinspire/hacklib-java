package com.falcinspire.hacklib.treev2

import com.falcinspire.hacklib.treev2.dfs.PostOrderDfsListener
import com.falcinspire.hacklib.treev2.dfs.PreOrderDfsListener
import com.falcinspire.hacklib.treev2.dfs.postOrderDfs
import com.falcinspire.hacklib.treev2.dfs.preOrderDfs

class SubtreeSumTree(val size: Int) {
    private val tree = createUndirectedIndexedTree(size) {ValueNode()}
    private val table = SubtreeSumTable(size)

    fun connect(a: Int, b: Int) = tree.connect(a, b)
    fun value(node: Int, value: Int) {
        tree.value(node).value = value
    }

    fun dp() {
        var dfsIndex = 0
        tree.preOrderDfs(0, object: PreOrderDfsListener<ValueNode, Unit> {
            override fun makeDefault() {}
            override fun merge(node: Int, parent: Int, result: Unit) {
                table.setOrder(node, dfsIndex)
                table.setValue(dfsIndex, tree.value(node).value)
                dfsIndex++
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
    }

    fun printTable() {
        table.print()
    }

    fun sum(node: Int): Int {
        val order = table.getOrder(node)
        val size = table.getSize(order)
        return if (order - 1 < 0)
            table.sum(order + size - 1)
        else
            table.sum(order + size - 1) - table.sum(order - 1)
    }
}