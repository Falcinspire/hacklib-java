package com.falcinspire.hacklib.treev2.dfs

interface PostOrderDfsListener<T, U> {
    fun makeDefault(): U
    fun reduce(parent: Int, cumulative: U, nodeB: Int, b: U): U
    fun merge(nodeA: Int, result: U): U
}