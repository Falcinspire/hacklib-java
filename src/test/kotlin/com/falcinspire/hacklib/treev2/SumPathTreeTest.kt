package com.falcinspire.hacklib.treev2

import org.junit.Test

class SumPathTreeTest {
    @Test
    fun test() {
        val tree = SumPathTree(9)

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

        tree.dp()
        tree.printTable()
        println(tree.pathSum(0))
        println(tree.pathSum(3))
        println(tree.pathSum(6))
        println(tree.pathSum(7))
        println(tree.pathSum(8))
        tree.update(3, 5)
        tree.printTable()
        println(tree.pathSum(0))
        println(tree.pathSum(3))
        println(tree.pathSum(6))
        println(tree.pathSum(7))
        println(tree.pathSum(8))
    }
}