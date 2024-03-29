package com.falcinspire.hacklib.tree

import org.junit.Assert
import org.junit.Test

class LongestPathTreeTester {
    @Test
    fun test() {
        val tree = LongestPathTree(6)
        tree.connect(0, 1)
        tree.connect(0, 2)
        tree.connect(0, 3)
        tree.connect(1, 4)
        tree.connect(1, 5)
        tree.calculateThings()
        Assert.assertEquals(2, tree.longestPath(0))
        Assert.assertEquals(3, tree.longestPath(3))
        Assert.assertEquals(2, tree.longestPath(1))
    }
}