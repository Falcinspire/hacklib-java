package com.falcinspire.hacklib.treev2

import com.falcinspire.hacklib.math.pow2Cieling
import java.lang.Integer.max
import java.lang.Integer.min

class SegmentTree<T>(val size: Int, val tree: BinaryTree<T>, val reducer: SegmentTreeReducer<T>) {

    /* Parameters are inclusive */
    fun range(start: Int, end: Int): T {
        var sum = reducer.makeDefault()
        var leftTracer = start + size
        var rightTracer = end + 1 + size
        while (leftTracer < rightTracer) {
            if (!beginsRange(leftTracer)) {
                sum = reducer.reduce(sum, tree.get(leftTracer))
                leftTracer = tree.adjacentRight(leftTracer)
            }
            if (!beginsRange(rightTracer)) {
                rightTracer = tree.adjacentLeft(rightTracer)
                sum = reducer.reduce(sum, tree.get(rightTracer))
            }
            leftTracer = tree.parent(leftTracer)
            rightTracer = tree.parent(rightTracer)
        }
        return sum
    }

    fun update(index: Int, value: T) {
        var node = index + size
        tree.set(node, value)
        while (node > 1) {
            tree.setParent(node, reducer.reduce(tree.get(node), tree.getAdjacent(node)))
            node = tree.parent(node)
        }
    }

    private fun beginsRange(node: Int) = node % 2 == 0

    companion object {

        val SUM = object: SegmentTreeReducer<Int> {
            override fun makeDefault() = 0
            override fun reduce(a: Int, b: Int) = a + b
        }
        val MAX = object: SegmentTreeReducer<Int> {
            override fun makeDefault() = Int.MIN_VALUE
            override fun reduce(a: Int, b: Int) = max(a, b)
        }
        val MIN = object: SegmentTreeReducer<Int> {
            override fun makeDefault() = Int.MAX_VALUE
            override fun reduce(a: Int, b: Int) = min(a, b)
        }
    }
}

inline fun <reified T> createSegmentTree(array: Array<T>, reducer: SegmentTreeReducer<T>): SegmentTree<T> {
    val defaultValue = reducer.makeDefault()

    val adjustedSize = pow2Cieling(array.size)
    val storage = createBinaryTree(2 * adjustedSize) {defaultValue}

    // base case, fill the bottom array with the actual elements
    repeat (array.size) {
        storage.set(adjustedSize + it, array[it])
    }

    // reduce up the tree
    for (parent in (adjustedSize - 1) downTo 0) {
        storage.set(parent, reducer.reduce(storage.getLeftChild(parent), storage.getRightChild(parent)))
    }

    return SegmentTree(adjustedSize, storage, reducer)
}
