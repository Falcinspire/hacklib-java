package com.falcinspire.hacklib.math

fun modularExponentiate(n: Int, power: Int, mod: Int = Int.MAX_VALUE): Int = when {
    power == 0 -> 1 % mod
    power % 2 == 0 -> {
        val raise = modularExponentiate(n % mod, power / 2, mod)
        (raise * raise) % mod
    }
    else -> {
        ((n % mod) * modularExponentiate(n % mod, power - 1, mod)) % mod
    }
}