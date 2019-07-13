package com.falcinspire.hacklib.treev2

import com.falcinspire.hacklib.treev2.dfs.PostOrderDfsListener
import com.falcinspire.hacklib.treev2.dfs.PreOrderDfsListener
import com.falcinspire.hacklib.treev2.dfs.postOrderDfs
import com.falcinspire.hacklib.treev2.dfs.preOrderDfs
import java.lang.Integer.max

class LongestPathTree(val size: Int) {
    private val tree = createUndirectedIndexedTree(size) {LongestPathNode()}

    fun connect(a: Int, b: Int) {
        tree.connect(a, b)
    }

    fun longestPath(node: Int) = tree.value(node).paths.first.distance
    fun traceLongestPath(node: Int): List<Int> {
        val path = mutableListOf<Int>()
        var last = node
        var current = node
        while (current != -1) {
            path.add(current)
            val next = if (tree.value(current).paths.first.node != last)
                tree.value(current).paths.first.node
            else
                tree.value(current).paths.second.node
            last = current
            current = next
        }
        return path
    }

    fun dpHeights() {
        tree.postOrderDfs(0, object: PostOrderDfsListener<LongestPathNode, LongestPathPair> {
            override fun makeDefault() = LongestPathPair(
                LongestPathOrigin(0, -1),
                LongestPathOrigin(0, -1)
            )
            override fun reduce(
                parent: Int,
                cumulative: LongestPathPair,
                nodeB: Int,
                b: LongestPathPair
            ): LongestPathPair {
                if (b.first.distance + 1 > cumulative.first.distance) {
                    cumulative.second = cumulative.first
                    cumulative.first = LongestPathOrigin(b.first.distance + 1, nodeB)
                } else if (b.first.distance + 1 > cumulative.second.distance) {
                    cumulative.second = LongestPathOrigin(b.first.distance + 1, nodeB)
                }
                return cumulative
            }

            override fun merge(nodeA: Int, result: LongestPathPair): LongestPathPair {
                tree.value(nodeA).paths = result
                return tree.value(nodeA).paths
            }
        })
    }

    fun dpLongestPaths() {
        tree.preOrderDfs(0, object: PreOrderDfsListener<LongestPathNode, Unit> {
            override fun makeDefault() {}
            override fun merge(node: Int, parent: Int, result: Unit) {
                // skip root
                if (node == 0) return

                val parentPair = tree.value(parent).paths
                val parentUpward = if (parentPair.first.node != node)
                    parentPair.first
                else
                    parentPair.second
                val upward = if (parentPair.first.node != node)
                    LongestPathOrigin(parentPair.first.distance + 1, parent)
                else
                    LongestPathOrigin(parentPair.second.distance + 1, parent)

                val pair = tree.value(node).paths
                if (upward.distance > pair.first.distance) {
                    pair.second = pair.first
                    pair.first = upward
                } else if (upward.distance > pair.second.distance) {
                    pair.second = upward
                }
            }
        })
    }
}