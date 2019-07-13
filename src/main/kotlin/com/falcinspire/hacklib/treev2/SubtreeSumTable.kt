package com.falcinspire.hacklib.treev2

class SubtreeSumTable(val nodes: Int) {
    private val dfs = IntArray(nodes) {-1}
    private val subtreeSizes = IntArray(nodes) {-1}
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

    fun sum(end: Int) = tree.sum(end)

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
            print("${tree.sum(it)} ")
        }
        println()
    }
}