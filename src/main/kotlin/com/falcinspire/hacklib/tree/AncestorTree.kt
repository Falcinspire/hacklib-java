package com.falcinspire.hacklib.tree

import com.falcinspire.hacklib.math.log2floor
import com.falcinspire.hacklib.math.pow2

class AncestorTree(val size: Int) {

    private val maxJump = log2floor(size)
    private val nodes = Array(size) { AncestorNode() }
    val ancestors = Array(size) {
        IntArray(maxJump + 1) {-1}
    }

    fun connect(a: Int, b: Int) {
        nodes[a].children.add(b)
        nodes[b].children.add(a)
    }

    fun dp() {
        dpFirstAncestors()
        for (power2 in 1..maxJump) {
            dpKthAncestors(power2)
        }
    }

    fun calculateAncestor(node: Int, k: Int): Int {
        var current = node
        var jumper = k
        while (jumper > 0) {
            val jump = log2floor(jumper)
            current = ancestor(current, jump)
            jumper -= pow2(jump)
        }
        return current
    }

    private fun ancestor(node: Int, power2: Int)  = ancestors[node][power2]
    private fun setAncestor(node: Int, power2: Int, ancestor: Int) {
        ancestors[node][power2] = ancestor
    }

    private fun dpFirstAncestors() {
        for (child in nodes[0].children) {
            dpFirstAncestor(0, child)
        }
    }

    private fun dpFirstAncestor(parent: Int, node: Int) {
        setAncestor(node, 0, parent)

        for (child in nodes[node].children) {
            if (child != parent)
                dpFirstAncestor(node, child)
        }
    }

    private fun dpKthAncestors(power2: Int) {
        dpKthAncestor(0, 0, power2)
    }

    private fun dpKthAncestor(parent: Int, node: Int, power2: Int) {
        val jumpAncestor = ancestor(node, power2 - 1)
        if (jumpAncestor != -1)
            setAncestor(node, power2, ancestor(jumpAncestor, power2 - 1))

        for (child in nodes[node].children) {
            if (child != parent)
                dpKthAncestor(node, child, power2)
        }
    }
}