package com.falcinspire.hacklib.tree

class DiameterTreeSampleBuilder {
    fun build(edgeTreeBuilder: EdgeTreeBuilder) {
        edgeTreeBuilder.connect(1, 5)
        edgeTreeBuilder.connect(1, 4)
        edgeTreeBuilder.connect(1, 0)
        edgeTreeBuilder.connect(0, 2)
        edgeTreeBuilder.connect(0, 3)
        edgeTreeBuilder.connect(3, 6)
    }
}