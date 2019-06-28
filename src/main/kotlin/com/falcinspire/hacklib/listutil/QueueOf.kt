package com.falcinspire.hacklib.listutil

import java.util.*

fun <T> queueOf(vararg elements: T): Queue<T> {
    val queue = LinkedList<T>()
    for (element in elements)
        queue.add(element)
    return queue
}