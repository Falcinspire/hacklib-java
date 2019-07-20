package com.falcinspire.hacklib.treev2

import com.falcinspire.hacklib.math.log2floor
import com.falcinspire.hacklib.math.pow2
import com.falcinspire.hacklib.treev2.dfs.PreOrderDfsListener
import com.falcinspire.hacklib.treev2.dfs.preOrderDfs

class AncesDepthTree(val size: Int) {

    private val MAX_LEVEL = log2floor(size)
    private val tree = createUndirectedIndexedTree(size) {AncesDepthNode(MAX_LEVEL + 1)}

    fun connect(a: Int, b: Int) {
        tree.connect(a, b)
    }

    fun dp() {
        // base case
        tree.preOrderDfs(0, object: PreOrderDfsListener<AncesDepthNode, Unit> {
            override fun makeDefault() {}
            override fun merge(node: Int, parent: Int, result: Unit) {
                if (node == 0) return // skip root

                setAncestor(node, 0, parent)
                tree.value(node).depth = tree.value(parent).depth + 1
            }
        })

        // k through MAX_LEVEL
        for (k in 1..MAX_LEVEL) {
            tree.preOrderDfs(0, object: PreOrderDfsListener<AncesDepthNode, Unit> {
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
    fun getDepth(node: Int) = tree.value(node).depth

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


    fun lowestCommonAncestor(a: Int, b: Int): Int {
        val (uInit, vInit) = initLowerHigher(a, b)
        val (uEqualized, vEqualized) = raiseUToV(uInit, vInit)

        return if (uEqualized == vEqualized)
            uEqualized /* == vEqualized */
        else
            getAncestor(jumpToLCAChild(uEqualized, vEqualized), 0)
    }

    fun distance(a: Int, b: Int) = getDepth(a) + getDepth(b) - 2 * getDepth(lowestCommonAncestor(a, b))

    private fun initLowerHigher(a: Int, b: Int) =
        if (getDepth(a) < getDepth(b))
            UVStruct(b, a) // swap
        else
            UVStruct(a, b) // don't swap

    private inner class UVStruct(val u: Int, val v: Int) {
        operator fun component1() = u
        operator fun component2() = v
    }

    private fun raiseUToV(u: Int, v: Int): UVStruct {
        var uCursor = u
        var vCursor = v

        var diff = getDepth(uCursor) - getDepth(vCursor)
        while (diff > 0) {
            val jump = log2floor(diff)
            uCursor = getAncestor(uCursor, jump)
            diff -= pow2(jump)
        }

        return UVStruct(uCursor, vCursor)
    }

    private fun jumpToLCAChild(u: Int, v: Int): Int {
        var uCursor = u
        var vCursor = v

        for (level in MAX_LEVEL downTo 0) {
            if (getAncestor(uCursor, level) != -1 && getAncestor(uCursor, level) != getAncestor(vCursor, level)) {
                uCursor = getAncestor(uCursor, level)
                vCursor = getAncestor(vCursor, level)
            }
        }

        return uCursor /* parent(uCursor) == parent(vCursor) */
    }
}