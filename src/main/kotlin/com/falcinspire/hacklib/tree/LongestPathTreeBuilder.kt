package com.falcinspire.hacklib.tree

class LongestPathTreeBuilder(val tree: LongestPathTree): EdgeTreeBuilder {
    override fun connect(a: Int, b: Int) {
        tree.connect(a, b)
    }
}