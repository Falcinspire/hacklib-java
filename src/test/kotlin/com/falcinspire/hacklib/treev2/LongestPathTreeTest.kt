package com.falcinspire.hacklib.treev2

import org.junit.Assert
import org.junit.Test

class LongestPathTreeTest {
    @Test
    fun test() {
        val tree = LongestPathTree(6)
        tree.connect(0, 1)
        tree.connect(0, 2)
        tree.connect(0, 3)
        tree.connect(1, 4)
        tree.connect(1, 5)
        tree.dpHeights()
        tree.dpLongestPaths()
        Assert.assertEquals(2, tree.longestPath(0))
        Assert.assertEquals(3, tree.longestPath(3))
        Assert.assertEquals(2, tree.longestPath(1))
        // IDK if this works in a general case
        println(tree.traceLongestPath(3))
    }
}