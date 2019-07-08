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
        Assert.assertEquals(tree.longestPath(0), 2)
        Assert.assertEquals(tree.longestPath(3), 3)
        Assert.assertEquals(tree.longestPath(1), 2)
    }
}