package com.falcinspire.hacklib.util

class IntReducer(private val def: Int = 0, val reduceFunction: (Int, Int) -> Int = Math::max): Reducer<Int> {
    override fun reduce(a: Int, b: Int) = reduceFunction(a, b)
    override fun getDefault() = def
}