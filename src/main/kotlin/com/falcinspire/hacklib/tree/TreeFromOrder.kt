package com.falcinspire.hacklib.tree

object TreeFromOrder {

    fun build(preOrder: PreOrder, inOrder: InOrder): BinaryNode {
        val tree = BinaryNode()
        build(0..inOrder.lastIndex, preOrder, inOrder, tree)
        return tree
    }

    private fun build(range: IntRange, preOrder: PreOrder, inOrder: InOrder, node: BinaryNode) {
        val root = findRoot(range, preOrder, inOrder)
        node.value = inOrder[root]
        val leftRange = (range.start)..(root - 1)
        if (leftRange.span() > 0) {
            val leftNode = BinaryNode()
            node.left = leftNode
            build(leftRange, preOrder, inOrder, leftNode)
        }
        val rightRange = (root + 1)..(range.endInclusive)
        if (rightRange.span() > 0) {
            val rightNode = BinaryNode()
            node.right = rightNode
            build(rightRange, preOrder, inOrder, rightNode)
        }
    }

    private fun findRoot(inorderRange: IntRange, preOrder: PreOrder, inOrder: InOrder): Int {
        for (inElement in inorderRange) {
            if (inOrder[inElement] == preOrder.peek()) {
                preOrder.poll()
                return inElement
            }
        }
        return -1
    }

}