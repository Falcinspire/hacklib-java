package com.falcinspire.hacklib.tree

import com.falcinspire.hacklib.listutil.queueOf
import com.falcinspire.hacklib.treev2.order.InOrder
import com.falcinspire.hacklib.treev2.order.PreOrder
import com.falcinspire.hacklib.treev2.order.TreeFromOrder
import org.junit.Test

class TreeFromOrderTest {
    @Test
    fun order() {
        val tree = TreeFromOrder.build(
            PreOrder(queueOf(1, 2, 4, 5, 6, 3, 7)),
            InOrder(listOf(4, 2, 6, 5, 1, 3, 7))
        )
        BinaryNodePrinter.inorder(tree)
        println()
        BinaryNodePrinter.preorder(tree)
        println()
        BinaryNodePrinter.postorder(tree)
        println()
    }
}