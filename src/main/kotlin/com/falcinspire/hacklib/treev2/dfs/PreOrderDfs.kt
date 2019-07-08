package com.falcinspire.hacklib.treev2.dfs

import com.falcinspire.hacklib.treev2.UndirectedIndexedTree

fun <T, U> UndirectedIndexedTree<T>.preOrderDfs(start: Int, listener: PreOrderDfsListener<T, U>) {
    val result = listener.merge(start, listener.makeDefault())
    preOrderDfsRecursive(start, start, result, listener)
}

private fun <T, U> UndirectedIndexedTree<T>.preOrderDfsRecursive(node: Int, parent: Int, parentValue: U, listener: PreOrderDfsListener<T, U>) {
    for (child in children(node)) {
        if (child == parent) continue

        val result = listener.merge(
            child,
            parentValue
        )

        preOrderDfsRecursive(child, node, result, listener)
    }
}