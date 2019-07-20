package com.falcinspire.hacklib.treev2.dfs

import com.falcinspire.hacklib.treev2.UndirectedIndexedTree
import java.util.*

// Implementation of the traditional dfs using a stack.
// This more closely resembles the traditional recursive dfs; the stack
// stores a node, its parent (undirected tree), the number of children
// it has, and the current child it's on. This is opposed to the naive
// implementation, which just dumps all children to the top of the stack
// as they come along.
//
// The top of the stack contains the node being visited.
// When the next value is requested, the first unvisited child of the top
// node is returned. If this elements does not exist, the tree is crawled
// upwards until one can be found
//
// This can be broken down into the following process:
// loop until both following conditions are false:
// 1.) the next child doesn't exist; pop off the head node and move the new top (head's parent) to the next child
//   * if the stack empties, then the entire tree has been visited
// 2.) the next child is the parent; skip it
// Return the next child and make it the new top of the stack
//
class IterativeStackDfs<T>(private val tree: UndirectedIndexedTree<T>): Iterator<Int> {

    private val stack = Stack<StackData>()
    private var current = 0

    init {
        stack.add(StackData(0, 0, countChildren(0), 0))
    }

    override fun next(): Int {
        val copy = current
        current = retrieveNext()
        return copy
    }

    override fun hasNext() = current != -1

    private fun retrieveNext(): Int {
        while(true) {
            if (noChildrenLeft()) {
                moveUp() // a subtree has been traversed here
                if (movedAboveRoot())
                    return /* Finished */ -1
                moveRight()
                continue
            }
            if (currentIsParent()) {
                moveRight()
                continue
            }
            break
        }
        moveDown()

        return currentNode()
    }

    private fun currentNode() = stack.peek().node
    private fun noChildrenLeft(): Boolean {
        val data = stack.peek()
        return data.currentChildIndex == data.childCount
    }
    private fun currentIsParent(): Boolean {
        val data = stack.peek()
        return childOf(data.node, data.currentChildIndex) == data.parent
    }

    private fun countChildren(node: Int) = tree.children(node).size
    private fun childOf(node: Int, child: Int) = tree.children(node)[child]

    private fun movedAboveRoot() = stack.isEmpty()
    private fun moveUp() {
        stack.pop()
    }
    private fun moveDown() {
        val data = stack.peek()
        val node = data.node
        val child = childOf(node, data.currentChildIndex)
        stack.push(StackData(child, node, countChildren(child), 0))
    }
    private fun moveRight() {
        val data = stack.pop()
        stack.push(StackData(data.node, data.parent, data.childCount, data.currentChildIndex + 1))
    }

    private inner class StackData(val node: Int, val parent: Int, val childCount: Int, val currentChildIndex: Int)
}