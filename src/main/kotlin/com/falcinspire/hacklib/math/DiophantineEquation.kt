package com.falcinspire.hacklib.math

/* Solves a diophantine equation where c is divisible by gcd(a,b) */
fun solveDivisibleDiophantineEquation(a: Int, b: Int, c: Int): LinearPairSolution {
    val (s, t, gcd) = euclidExtended(a, b)
    val multiplier = c / gcd
    val xSolution = s * multiplier
    val ySolution = t * multiplier
    return LinearPairSolution(xSolution, ySolution, a, b, gcd)
}