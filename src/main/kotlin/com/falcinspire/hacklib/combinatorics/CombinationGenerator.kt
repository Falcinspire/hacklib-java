import com.falcinspire.hacklib.combinatorics.CombinationListener

fun combinations(setSize: Int, subsetSize: Int, listener: CombinationListener) {
    combinationsRec(0, subsetSize, setSize, listener)
}

private fun combinationsRec(start: Int, remaining: Int, size: Int, listener: CombinationListener) {
    if (remaining == 0) {
        listener.ready()
        return
    }
    for (i in start..(size - remaining)) {
        listener.add(i)
        combinationsRec(i + 1, remaining - 1, size, listener)
        listener.remove(i)
    }
}