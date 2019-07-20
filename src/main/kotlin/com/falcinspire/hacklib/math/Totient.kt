package com.falcinspire.hacklib.math

/* Counts the number of coprime numbers up to n */
fun totient(n: Int)
    = primeFactorizeToPowers(n)
    .map { modularExponentiate(it.factor, it.power - 1) * (it.factor - 1) }
    .multiply()