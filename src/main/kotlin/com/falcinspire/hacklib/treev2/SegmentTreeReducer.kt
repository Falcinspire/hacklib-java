package com.falcinspire.hacklib.treev2

interface SegmentTreeReducer<T> {
    fun makeDefault(): T
    fun reduce(a: T, b: T): T
}