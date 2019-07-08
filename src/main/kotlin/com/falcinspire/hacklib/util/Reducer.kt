package com.falcinspire.hacklib.util

interface Reducer<T> {
    fun reduce(a: T, b: T): T
    fun getDefault(): T
}