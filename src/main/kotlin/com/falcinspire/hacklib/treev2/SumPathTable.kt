package com.falcinspire.hacklib.treev2

class SumPathTable(val nodes: Int) {
    private val dfs = IntArray(nodes) {-1}
    private val subtreeSizes = IntArray(nodes) {-1}
    private val cumulSums = IntArray(nodes) {-1}
    private val tree = FenwickTree(nodes)

    fun setOrder(node: Int, orderIndex: Int) {
        dfs[node] = orderIndex
    }
    fun getOrder(node: Int) = dfs[node]

    fun setSize(node: Int, size: Int) {
        subtreeSizes[node] = size
    }
    fun getSize(node: Int) = subtreeSizes[node]

    fun setValue(node: Int, value: Int) {
        tree.update(node, value)
    }

    fun setPath(node: Int, value: Int) {
        cumulSums[node] = value
    }
    fun getPath(node: Int) = cumulSums[node]

    fun buildDifferenceArray() {
        tree.update(0, cumulSums[0])
        for (i in 1 until nodes) {
            tree.update(i, cumulSums[i] - cumulSums[i - 1])
        }
    }

    fun value(end: Int) = tree.sum(end)
    fun updateRange(start: Int, end: Int, change: Int) {
        tree.update(start, change)
        if (end + 1 < tree.backingSize) {
            tree.update(end + 1, -change)
        }
    }

    fun print() {
        repeat(nodes) {
            print("${dfs[it]} ")
        }
        println()

        repeat(nodes) {
            print("${subtreeSizes[it]} ")
        }
        println()

        repeat(nodes) {
            print("${cumulSums[it]} ")
        }
        println()

        repeat(nodes) {
            print("${tree.sum(it)} ")
        }
        println()
    }
}