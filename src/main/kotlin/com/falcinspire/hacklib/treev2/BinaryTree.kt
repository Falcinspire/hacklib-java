package com.falcinspire.hacklib.treev2

class BinaryTree<T>(val size: Int, val array: Array<T>) {

    val realSize: Int
        get() = size + 1

    fun leftChild(node: Int) = node * 2
    fun rightChild(node: Int) = node * 2 + 1
    fun parent(node: Int) = node / 2
    fun setLeftChild(node: Int, value: T) {
        array[leftChild(node)] = value
    }
    fun setRightChild(node: Int, value: T) {
        array[rightChild(node)] = value
    }
    fun setParent(node: Int, value: T) {
        array[parent(node)] = value
    }
    fun getLeftChild(node: Int) = array[leftChild(node)]
    fun getRightChild(node: Int) = array[rightChild(node)]
    fun getAdjacentLeft(node: Int) = array[adjacentLeft(node)]
    fun getAdjacentRight(node: Int) = array[adjacentRight(node)]
    fun getAdjacent(node: Int) = array[adjacent(node)]
    fun set(node: Int, value: T) {
        array[node] = value
    }
    fun get(node: Int) = array[node]

    fun adjacentLeft(node: Int) = node - 1
    fun adjacentRight(node: Int) = node + 1
    fun adjacent(node: Int) = node xor 1

    companion object {
        val ROOT = 1
    }
}

inline fun <reified T> createBinaryTree(size: Int, initializer: (Int) -> T): BinaryTree<T> {
    val realSize = size + 1
    return BinaryTree(size, Array(realSize){initializer(it)})
}