package com.falcinspire.hacklib.tree

fun subtractRightmostBit(number: Int) = number - isolateRightmostBit(number)
fun addRightmostBit(number: Int) = number + isolateRightmostBit(number)
fun isolateRightmostBit(number: Int) = number and -number