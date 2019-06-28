package com.falcinspire.hacklib.search

import java.lang.Math.abs

object UnimodalTernarySearch {

    fun ternarySearch(low: Float, high: Float, precisionWrapper: Precision, function: (Float) -> Float, minimum: Boolean) =
            ternarySearchPrecision(low, high, precisionWrapper.value, function, minimum)

    private fun ternarySearchPrecision(low: Float, high: Float, precision: Float, function: (Float) -> Float, minimum: Boolean): Float {
        val a = (low * 2 + high) / 3
        val b = (low + high * 2) / 3

        println("$low, $a(${function(a)}), $b(${function(b)}), $high")
        if (abs(high - low) < precision) {
            return (low + high) / 2
        }

        val aValue = function(a)
        val bValue = function(b)
        return if (minimum) {
            when {
                aValue < bValue -> ternarySearchPrecision(low, b, precision, function, minimum)
                else -> ternarySearchPrecision(a, high, precision, function, minimum)
            }
        } else {
            when {
                aValue > bValue -> ternarySearchPrecision(low, b, precision, function, minimum)
                else -> ternarySearchPrecision(a, high, precision, function, minimum)
            }
        }
    }

    fun ternarySearch(low: Float, high: Float, countWrapper: Count, function: (Float) -> Float, minimum: Boolean) =
        ternarySearchCount(low, high, countWrapper.value, function, minimum)

    private fun ternarySearchCount(low: Float, high: Float, count: Int, function: (Float) -> Float, minimum: Boolean): Float {
        val a = (low * 2 + high) / 3
        val b = (low + high * 2) / 3

        if (count == 0) return a

        val aValue = function(a)
        val bValue = function(b)
        return if (minimum) {
            when {
                aValue < bValue -> ternarySearchCount(low, b, count - 1, function, minimum)
                else -> ternarySearchCount(a, high, count - 1, function, minimum)
            }
        } else {
            when {
                aValue > bValue -> ternarySearchCount(low, b, count - 1, function, minimum)
                else -> ternarySearchCount(a, high, count - 1, function, minimum)
            }
        }
    }
}