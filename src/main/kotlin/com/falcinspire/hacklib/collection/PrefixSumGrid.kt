package com.falcinspire.hacklib.collection

class PrefixSumGrid(private val array: Array<IntArray>) {

    val width = array.size
    val height = array[0].size

    fun sum(x1: Int, y1: Int, x2: Int, y2: Int) = sumOriginToXY(x2, y2) -
            sumOriginToXY(x1 - 1, y2) - sumOriginToXY(x2, y1 - 1) +
            sumOriginToXY(x1 - 1, y1 - 1)

    operator fun get(x: Int, y: Int) = array[y][x]

    private fun sumOriginToXY(x: Int, y: Int) = if (x < 0 || y < 0) 0 else array[y][x]

    companion object {
        fun create(array: Array<IntArray>): PrefixSumGrid {
            val prefixGrid = Array(array.size) {
                IntArray(array[0].size) {0}
            }
            createPrefixArray(prefixGrid[0], array[0])
            createPrefixGrid(prefixGrid, array)
            return PrefixSumGrid(prefixGrid)
        }
        fun createPrefixArray(prefixArray: IntArray, original: IntArray) {
            prefixArray[0] = original[0]
            for (x in 1..original.lastIndex) {
                prefixArray[x] = prefixArray[x - 1] + original[x]
            }
        }
        fun createPrefixGrid(prefixGrid: Array<IntArray>, array: Array<IntArray>) {
            for (y in 1..array.lastIndex) {
                prefixGrid[y][0] = prefixGrid[y - 1][0] + array[y][0]
                for (x in 1..array[0].lastIndex) {
                    prefixGrid[y][x] = prefixGrid[y - 1][x] + prefixGrid[y][x - 1] - prefixGrid[y - 1][x - 1] + array[y][x]
                }
            }
        }
    }
}