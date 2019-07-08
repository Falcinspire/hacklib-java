package com.falcinspire.hacklib.tree

data class LongestPathNode(var children: MutableList<Int> = mutableListOf(),
                      var height: Int = -1,
                      var parentPath1: LongestPath = LongestPath(),
                      var parentPath2: LongestPath = LongestPath())