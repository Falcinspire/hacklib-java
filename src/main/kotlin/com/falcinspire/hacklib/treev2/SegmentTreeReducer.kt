package com.falcinspire.hacklib.treev2

class SegmentTreeReducer(val defaultValue: Int, val reduce: (Int, Int) -> Int)