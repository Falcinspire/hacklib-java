package com.falcinspire.hacklib.treev2

import com.falcinspire.hacklib.util.MutableInt

class LowestCommonAncestorTree(val size: Int) {
    private val tree = createUndirectedIndexedTree(size){}

    private val walkSize = size * 2 - 1
    private val firstAppearance = IntArray(walkSize)
    private val eulerWalk = Array(walkSize) {LeveledNode()}
    private lateinit var segmentTree: SegmentTree<LeveledNode>

    fun connect(a: Int, b: Int) {
        tree.connect(a, b)
    }

    fun lowestCommonAncestor(a: Int, b: Int): Int {
        val aFirst = firstAppearance[a]
        val bFirst = firstAppearance[b]
        return if (aFirst < bFirst)
            segmentTree.range(aFirst, bFirst).node
        else
            segmentTree.range(bFirst, aFirst).node
    }

    fun dp() {
        rec(0, 0, 0, MutableInt())
        segmentTree = createSegmentTree(eulerWalk, object: SegmentTreeReducer<LeveledNode> {
            override fun makeDefault() = LeveledNode(-1, Int.MAX_VALUE)
            override fun reduce(a: LeveledNode, b: LeveledNode) = if (a.level < b.level)
                a
            else
                b
        })
    }

    private fun rec(node: Int, parent: Int, level: Int, mutableInt: MutableInt) {
        eulerWalk[mutableInt.value] = LeveledNode(node, level)
        firstAppearance[node] = mutableInt.value
        mutableInt.value++
        for (child in tree.children(node)) {
            if (child == parent) continue

            rec(child, node, level + 1, mutableInt)

            eulerWalk[mutableInt.value] = LeveledNode(node, level)
            mutableInt.value++
        }
    }

    fun printTable() {
        repeat(size) {
            print("${firstAppearance[it]} ")
        }
        println()

        repeat(walkSize) {
            print("${eulerWalk[it]} ")
        }
        println()
    }
}