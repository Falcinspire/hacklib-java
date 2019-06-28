package com.falcinspire.hacklib.tree

class DiameterDFSTree(val nodeCount: Int) {

    private val nodes = Array(nodeCount) { DiameterDFSNode() }

    fun connect(a: Int, b: Int) {
        nodes[a].children.add(b)
        nodes[b].children.add(a)
    }

    fun diameter(): Int {
        val a = dfsSearch(0, 0)
        val b = dfsSearch(a.node, a.node)
        return b.length
    }

    private fun dfsSearch(parent: Int, node: Int): NodeDistance {
        var max = NodeDistance(node, -1)
        for (child in nodes[node].children) {
            if (child != parent) {
                val result = dfsSearch(node, child)
                if (result.length > max.length)
                    max = result
            }
        }
        return NodeDistance(max.node, max.length + 1)
    }

    inner class NodeDistance(val node: Int, val length: Int)
}