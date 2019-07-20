package com.falcinspire.hacklib.math

fun countFactors(n: Int)
        = primeFactorizeToPowers(n)
        .map { it.power + 1 }
        .multiply()