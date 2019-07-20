package com.falcinspire.hacklib.math

fun primeFactorizeToList(n: Int): ArrayList<Int> {
    var currentN = n
    val factors = ArrayList<Int>()
    var x = 2
    while (x * x <= currentN) {
        while (currentN % x == 0) {
            factors.add(x)
            currentN /= x
        }
        x += 1
    }
    if (currentN > 1)
        factors.add(currentN)
    return factors
}

fun primeFactorizeToPowers(n: Int): ArrayList<PowerFactor> {
    var currentN = n
    val factors = ArrayList<PowerFactor>()
    var x = 2
    while (x * x <= currentN) {
        var power = 0
        while (currentN % x == 0) {
            power++
            currentN /= x
        }
        if (power > 0)
            factors.add(PowerFactor(x, power))
        x += 1
    }
    if (currentN > 1)
        factors.add(PowerFactor(currentN, 1))
    return factors
}

class PowerFactor(val factor: Int, val power: Int) {
    override fun toString() = "$factor^$power"
}