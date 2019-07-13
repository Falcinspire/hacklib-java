package com.falcinspire.hacklib.tree

import com.sun.javafx.geom.Edge
import java.lang.Integer.max

//THIS MAY BE BROKEN FOR SOME PATHS
class LongestPathTree(val size: Int) {
    val nodes = Array(size) { LongestPathNode() }

    fun connect(a: Int, b: Int) {
        nodes[a].children.add(b)
        nodes[b].children.add(a)
    }

    fun longestPath(node: Int) = max(nodes[node].parentPath1.height, nodes[node].height)

    fun calculateThings() {
        calculateHeights(0, 0)
        calculateParentPathRoot()
        nodes[0].children.forEach {
            calculateParentPath(0, it)
        }
    }

    private fun calculateHeights(parent: Int, node: Int) {
        val children = nodes[node].children

        for (child in children) {
            if (child == parent) continue

            calculateHeights(node, child)
        }

        var maxHeight = -1
        for (child in children) {
            if (child == parent) continue

            maxHeight = max(maxHeight, nodes[child].height)
        }
        nodes[node].height = maxHeight + 1
    }

    private fun calculateParentPathRoot() {
        val top2 = longest2Paths(nodes[0].children)

        nodes[0].parentPath1 = top2[0]
        nodes[0].parentPath2 = top2[1]
    }

    private fun longest2Paths(children: List<Int>): Array<LongestPath> {
        var firstChild = -1
        var firstHeight = -2
        var secondChild = -1
        var secondHeight = -2

        for (child in children) {
            if (nodes[child].height > firstChild) {
                secondChild = firstChild
                secondHeight = firstHeight

                firstChild = child
                firstHeight = nodes[child].height
            }
            else if (nodes[child].height > secondChild) {
                secondChild = child
                secondHeight = nodes[child].height
            }
        }
        return arrayOf(
            LongestPath(firstChild, firstHeight + 1),
            LongestPath(secondChild, secondHeight + 1)
        )
    }

    private fun longestPathFromChildren(parent: Int, children: List<Int>): LongestPath {
        var firstChild = -1
        var firstLength = -2
        for (child in children) {
            if (child == parent) continue

            if (nodes[child].height > firstLength) {
                firstChild = child
                firstLength = nodes[child].height
            }
        }
        return LongestPath(firstChild, firstLength + 1)
    }

    private fun calculateParentPath(parent: Int, node: Int) {
        nodes[node].parentPath1 = if (nodes[parent].parentPath1.child != node) {
            LongestPath(parent, nodes[parent].parentPath1.height + 1)
        } else {
            LongestPath(parent, nodes[parent].parentPath2.height + 1)
        }

        val children = nodes[node].children
        nodes[node].parentPath2 = longestPathFromChildren(parent, children)

        for (child in children) {
            if (child == parent) continue

            calculateParentPath(node, child)
        }
    }
}