class PrefixSumArray(private val array: IntArray) {

    val size = array.size

    operator fun get(startIndex: Int, endIndex: Int) = from0toI(endIndex) - from0toI(startIndex - 1)
    fun from0toI(index: Int) = if (index < 0) 0 else array[index]

    companion object {
        fun create(array: IntArray): PrefixSumArray {
            val prefixArray = IntArray(array.size) {0}
            prefixArray[0] = array[0]
            repeat(array.size - 1) {
                val index = it + 1
                prefixArray[index] = prefixArray[index - 1] + array[index]
            }
            return PrefixSumArray(prefixArray)
        }
    }
}