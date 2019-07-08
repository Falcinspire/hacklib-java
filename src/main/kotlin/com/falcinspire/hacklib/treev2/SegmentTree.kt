package com.falcinspire.hacklib.treev2

import com.falcinspire.hacklib.math.pow2Cieling

class SegmentTree(val size: Int, val tree: BinaryTree<Int>, val segmentReduce: SegmentTreeReducer) {

    /* Parameters are inclusive */
    fun range(start: Int, end: Int): Int {
        val reduce = segmentReduce.reduce
        val defualtValue = segmentReduce.defaultValue

        var sum = defualtValue
        var leftTracer = start + size
        var rightTracer = end + 1 + size
        while (leftTracer < rightTracer) {
            if (!beginsRange(leftTracer)) {
                sum = reduce(sum, tree.get(leftTracer))
                leftTracer = tree.adjacentRight(leftTracer)
            }
            if (!beginsRange(rightTracer)) {
                rightTracer = tree.adjacentLeft(rightTracer)
                sum = reduce(sum, tree.get(rightTracer))
            }
            leftTracer = tree.parent(leftTracer)
            rightTracer = tree.parent(rightTracer)
        }
        return sum
    }

    fun update(index: Int, value: Int) {
        val reduce = segmentReduce.reduce

        var node = index + size
        tree.set(node, value)
        while (node > 1) {
            tree.setParent(node, reduce(tree.get(node), tree.getAdjacent(node)))
            node = tree.parent(node)
        }
    }

    private fun beginsRange(node: Int) = node % 2 == 0

    companion object {

        val SUM = SegmentTreeReducer(0) { a: Int, b: Int -> a + b}
        val MAX = SegmentTreeReducer(Integer.MIN_VALUE, Integer::max)
        val MIN = SegmentTreeReducer(Integer.MAX_VALUE, Integer::min)

        fun build(array: IntArray, segmentReduce: SegmentTreeReducer): SegmentTree {
            val defaultValue = segmentReduce.defaultValue
            val reduce = segmentReduce.reduce

            val adjustedSize = pow2Cieling(array.size)
            val storage = createBinaryTree(2 * adjustedSize) {defaultValue}

            // base case, fill the bottom array with the actual elements
            repeat (array.size) {
                storage.set(adjustedSize + it, array[it])
            }

            // reduce up the tree
            for (parent in (adjustedSize - 1) downTo 0) {
                storage.set(parent, reduce(storage.getLeftChild(parent), storage.getRightChild(parent)))
            }

            return SegmentTree(adjustedSize, storage, segmentReduce)
        }
    }
}