package com.falcinspire.hacklib.math

fun coprimeModularInverse(n: Int, mod: Int) = fastModularExponentiate(n, totient(mod) - 1, mod)
fun primeModularInverse(n: Int, mod: Int) = fastModularExponentiate(n, mod - 2, mod)