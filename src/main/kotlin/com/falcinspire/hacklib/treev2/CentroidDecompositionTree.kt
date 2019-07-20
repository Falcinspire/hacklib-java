package com.falcinspire.hacklib.treev2

class CentroidDecompositionTree(val size: Int) {
    private val tree = createUndirectedIndexedTree(size) {CentroidDecompositionNode()}
    val decomposition = createUndirectedIndexedTree(size) {}

    fun connect(a: Int, b: Int) {
        tree.connect(a, b)
    }

    private fun sizeRecurse(node: Int, parent: Int) {
        var size = 0
        for (child in tree.children(node)) {
            if (child == parent) continue
            if (tree.value(child).isCentroid) continue

            sizeRecurse(child, node)
            size += tree.value(child).size
        }
        tree.value(node).size = size + 1
    }

    fun decompose() = decomposeSubtree(0, -1)

    private fun decomposeSubtree(node: Int, decomp: Int): Int {
        sizeRecurse(node, -1)
        val centroid = locateCentroid(node, node, -1)
        tree.value(centroid).isCentroid = true
        if (decomp != -1) // root of decomposition tree
            decomposition.connect(decomp, centroid)

        for (child in tree.children(centroid)) {
            if (tree.value(child).isCentroid) continue

            decomposeSubtree(child, centroid)
        }

        return centroid
    }

    private fun locateCentroid(node: Int, root: Int, parent: Int): Int {
        for (child in tree.children(node)) {
            if (child == parent) continue
            if (tree.value(child).isCentroid) continue

            if (tree.value(child).size > tree.value(root).size / 2) {
                return locateCentroid(child, root, node)
            }
        }
        return node
    }
}