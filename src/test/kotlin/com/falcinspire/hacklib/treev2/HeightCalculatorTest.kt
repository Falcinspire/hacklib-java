package com.falcinspire.hacklib.treev2

import org.junit.Test

class HeightCalculatorTest {
    @Test
    fun test() {
        val tree = createUndirectedIndexedTree(7) {}
        tree.connect(1, 5)
        tree.connect(1, 4)
        tree.connect(1, 0)
        tree.connect(0, 2)
        tree.connect(0, 3)
        tree.connect(3, 6)
        val height = HeightCalculator().calculateHeight(tree)
        println(height)
    }
}