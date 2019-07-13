package com.falcinspire.hacklib.treev2

import org.junit.Assert
import org.junit.Test

class SubtreeSumTreeTest {
    @Test
    fun test() {
        val tree = SubtreeSumTree(9)
        tree.connect(0, 1)
        tree.connect(1, 5)
        tree.connect(0, 2)
        tree.connect(0, 3)
        tree.connect(3, 6)
        tree.connect(3, 7)
        tree.connect(3, 8)
        tree.connect(0, 4)

        tree.value(0, 2)
        tree.value(1, 3)
        tree.value(5, 4)
        tree.value(2, 5)
        tree.value(3, 3)
        tree.value(6, 4)
        tree.value(7, 3)
        tree.value(8, 1)
        tree.value(4, 1)

        tree.dp()
//        tree.printTable()

        Assert.assertEquals(11, tree.sum(3))
        Assert.assertEquals(26, tree.sum(0))
        Assert.assertEquals(4, tree.sum(5))
    }
}