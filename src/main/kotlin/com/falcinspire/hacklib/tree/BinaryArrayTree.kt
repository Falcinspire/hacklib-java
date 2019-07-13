package com.falcinspire.hacklib.tree

//TODO? this backingSize includes the unused element at 0
class BinaryArrayTree(val size: Int, val array: IntArray) {

    constructor(size: Int, defaultValue: Int = 0): this(size, IntArray(size){defaultValue})
    constructor(array: IntArray): this(array.size, array)

    fun leftChild(node: Int) = node * 2
    fun rightChild(node: Int) = node * 2 + 1
    fun parent(node: Int) = node / 2
    fun setLeftChild(node: Int, value: Int) {
        array[leftChild(node)] = value
    }
    fun setRightChild(node: Int, value: Int) {
        array[rightChild(node)] = value
    }
    fun setParent(node: Int, value: Int) {
        array[parent(node)] = value
    }
    fun getLeftChild(node: Int) = array[leftChild(node)]
    fun getRightChild(node: Int) = array[rightChild(node)]
    fun getAdjacentLeft(node: Int) = array[adjacentLeft(node)]
    fun getAdjacentRight(node: Int) = array[adjacentRight(node)]
    fun getAdjacent(node: Int) = array[adjacent(node)]
    fun set(node: Int, value: Int) {
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