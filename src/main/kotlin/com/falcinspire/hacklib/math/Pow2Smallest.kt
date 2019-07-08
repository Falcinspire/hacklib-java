package com.falcinspire.hacklib.math

/** Any number can be represented as a sum of powers of 2. Subtracts out the smallest of these powers */
fun subtractSmallestPow2(number: Int) = number - findSmallestPow2(number)
/** Any number can be represented as a sum of powers of 2. Adds the smallest of these powers */
fun addSmallestPow2(number: Int) = number + findSmallestPow2(number)
/** Any number can be represented as a sum of powers of 2. Finds the smallest of these powers */
fun findSmallestPow2(number: Int) = number and -number