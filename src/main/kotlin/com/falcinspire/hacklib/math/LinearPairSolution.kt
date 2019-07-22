package com.falcinspire.hacklib.math

class LinearPairSolution(private val x: Int, private val y: Int, private val a: Int, private val b: Int, private val gcd: Int) {
    fun generate(k: Int) = CoordinatePair(x + (k*b)/gcd, y + (k*a)/gcd)
}