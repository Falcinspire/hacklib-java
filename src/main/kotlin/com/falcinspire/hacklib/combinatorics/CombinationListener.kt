package com.falcinspire.hacklib.combinatorics

interface CombinationListener {
    fun add(index: Int)
    fun remove(index: Int)
    fun ready()
}