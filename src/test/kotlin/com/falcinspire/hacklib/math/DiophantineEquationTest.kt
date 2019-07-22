package com.falcinspire.hacklib.math

import org.junit.Test

class DiophantineEquationTest {
    @Test
    fun test() {
        println(solveDivisibleDiophantineEquation(39, 15, 12).generate(0))
    }
}