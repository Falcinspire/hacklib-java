package com.falcinspire.hacklib.tree

class SegmentTreeReducer(val defaultValue: Int, val reduce: (Int, Int) -> Int)