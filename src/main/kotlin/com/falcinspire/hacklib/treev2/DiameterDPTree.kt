package com.falcinspire.hacklib.treev2

import java.lang.Integer.max

class DiameterDPTree(val size: Int) {
    val tree = createUndirectedIndexedTree(size) {DiameterDPNode()}

    private fun dp() = dpRecursive(0, 0)
    private fun dpRecursive(node: Int, parent: Int) {
        var firstDiameter = 0
        var firstHeight = -1
        var secondHeight = -1

        for (child in tree.children(node)) {
            if (child == parent) return

            dpRecursive(child, node)

            if (getHeight(child) > firstHeight) {
                secondHeight = firstHeight
                firstHeight = tree.value(child).height
            } else if (getHeight(child) > secondHeight) {
                secondHeight = tree.value(child).height
            }

            if (getDiameter(child) > firstDiameter) {
                firstDiameter = tree.value(child).diameter
            }
        }

        val usingSelf = firstHeight + secondHeight + 2
        val inChild = firstDiameter

        setHeight(node, firstHeight + 1)
        setDiameter(node, max(usingSelf, inChild))
    }

    private fun getHeight(node: Int) = tree.value(node).height
    private fun setHeight(node: Int, value: Int) {
        tree.value(node).height = value
    }
    private fun getDiameter(node: Int) = tree.value(node).diameter
    private fun setDiameter(node: Int, value: Int) {
        tree.value(node).diameter = value
    }
}