package com.falcinspire.hacklib.math

fun sumFactors(n: Int)
        = primeFactorizeToPowers(n)
        .map { (fastModularExponentiate(it.factor, it.power + 1) - 1) / (it.factor - 1) }
        .multiply()