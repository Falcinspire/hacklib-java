package com.falcinspire.hacklib.treev2.dfs

interface PreOrderDfsListener<T, U> {
    fun makeDefault(): U
    fun merge(node: Int, parent: Int, result: U): U
}