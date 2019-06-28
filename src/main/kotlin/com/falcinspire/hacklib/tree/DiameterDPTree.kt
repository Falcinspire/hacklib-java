package com.falcinspire.hacklib.tree

import kotlin.math.max

class DiameterDPTree(val nodesSize: Int) {

    val nodes = Array(nodesSize) { DiameterDPNode() }

    fun connect(a: Int, b: Int) {
        nodes[a].children.add(b)
        nodes[b].children.add(a)
    }

    fun setupDp() {
        calculateHeightValues(0,0)
        calculateDiameterValues(0,0)
    }

    fun diameter(): Int {
        return nodes[0].diameter
    }

    private fun calculateHeightValues(parent: Int, node: Int) {
        var maxToLeaf = -1
        val children = nodes[node].children
        children.forEach {
            if (it != parent) {
                calculateHeightValues(node, it)
                if (nodes[it].height > maxToLeaf)
                    maxToLeaf = nodes[it].height
            }
        }
        nodes[node].height = maxToLeaf + 1
    }

    private fun calculateDiameterValues(parent: Int, node: Int) {
        // cannot be empty or this isn't a tree

        val children = nodes[node].children
        for (child in children) {
            if (child != parent)
            calculateDiameterValues(node, child)
        }

        nodes[node].diameter = max(
            longestSubtreeDiameter(children),
            longestDiameterThroughNode(children)
        )
    }

    private fun longestSubtreeDiameter(children: List<Int>) = children.map { nodes[it].diameter }.max()!!

    private fun longestDiameterThroughNode(children: List<Int>): Int {

        if (children.size == 1) {
            return nodes[children[0]].height + 1
        }

        var maxThrough = Integer.MIN_VALUE
        for (a in children) {
            for (b in children) {
                if (a != b) {
                    val length = nodes[a].height + nodes[b].height
                    if (length > maxThrough)
                        maxThrough = length
                }
            }
        }
        val connectingEdges = 2
        return maxThrough + connectingEdges
    }
}