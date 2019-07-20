package com.falcinspire.hacklib.math

fun euclidExtended(a: Int, b: Int) =
    if (a > b) euclidExtendedRecursive(a, b)
    else euclidExtendedRecursive(b, a)

private fun euclidExtendedRecursive(a: Int, b: Int): EuclidResult =
    if (b == 0) EuclidResult(1, 0, a)
    else {
        val result = euclidExtendedRecursive(b, a % b)
        EuclidResult(result.t, result.s - (a/b) * result.t, result.gcd)
    }

data class EuclidResult(val s: Int, val t: Int, val gcd: Int)