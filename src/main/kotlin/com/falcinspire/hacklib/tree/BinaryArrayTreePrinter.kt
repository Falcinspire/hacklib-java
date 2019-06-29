package com.falcinspire.hacklib.tree

import com.falcinspire.hacklib.math.pow2

class BinaryArrayTreePrinter {
    fun print(tree: BinaryArrayTree) {
        var cursor = 1
        var level = 0
        var lastNodeIndex = pow2(0)
        while (cursor < tree.size) {
            print("${tree.get(cursor)} ")
            if (cursor == lastNodeIndex) {
                level++
                lastNodeIndex += pow2(level)
                println()
            }
            cursor++
        }
    }
}