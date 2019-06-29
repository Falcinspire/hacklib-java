package com.falcinspire.hacklib.tree

import org.junit.Test

class BinaryArrayTreeTester {
    @Test
    fun test() {
        val tree = BinaryArrayTree(10)
        var node = BinaryArrayTree.ROOT
        tree.set(node, 5)
        tree.setLeftChild(node, 2)
        tree.setRightChild(node, 7)
        BinaryArrayTreePrinter().print(tree)
    }
}