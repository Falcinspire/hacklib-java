package com.falcinspire.hacklib.tree

class DiameterDPTreeBuilder(private val tree: DiameterDPTree): EdgeTreeBuilder {
    override fun connect(a: Int, b: Int) {
        tree.connect(a, b)
    }
}