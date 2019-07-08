package com.falcinspire.hacklib.treev2

class UndirectedIndexedTree<T>(private val nodes: Array<UndirectedIndexedNode<T>>) {
    val size = nodes.size

    fun connect(a: Int, b: Int) {
        nodes[a].children.add(b)
        nodes[b].children.add(a)
    }

    fun node(id: Int) = nodes[id]
    fun value(id: Int) = nodes[id].data
    fun children(id: Int) = nodes[id].children
}

inline fun <reified T> createUndirectedIndexedTree(size: Int, initializer: (Int) -> T) =
        UndirectedIndexedTree(Array(size) {UndirectedIndexedNode(initializer(it))})