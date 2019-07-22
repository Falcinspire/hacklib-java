package com.falcinspire.hacklib.math

fun fastModularExponentiate(n: Int, power: Int, mod: Int = Int.MAX_VALUE): Int = when {
    power == 0 -> 1 % mod
    power % 2 == 0 -> {
        val raise = fastModularExponentiate(n % mod, power / 2, mod)
        (raise * raise) % mod
    }
    else -> {
        ((n % mod) * fastModularExponentiate(n % mod, power - 1, mod)) % mod
    }
}