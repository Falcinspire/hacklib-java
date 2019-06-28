package com.falcinspire.hacklib.tree

class DiameterDFSTreeBuilder(private val tree: DiameterDFSTree): EdgeTreeBuilder {
    override fun connect(a: Int, b: Int) {
        tree.connect(a, b)
    }
}