package com.falcinspire.hacklib.treev2.dfs

import com.falcinspire.hacklib.treev2.UndirectedIndexedTree

fun <T, U> UndirectedIndexedTree<T>.postOrderDfs(start: Int, listener: PostOrderDfsListener<T, U>) =
    postOrderDfsRecursive(start, start, listener)

private fun <T, U> UndirectedIndexedTree<T>.postOrderDfsRecursive(node: Int, parent: Int, listener: PostOrderDfsListener<T, U>): U {
    var result = listener.makeDefault()
    for (child in children(node)) {
        if (child == parent) continue

        result = listener.reduce(
            node,
            result,
            child,
            postOrderDfsRecursive(child, node, listener)
        )

    }
    result = listener.merge(node, result)
    return result
}