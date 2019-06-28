import kotlin.math.min

class MinimumRange(private val table: Array<IntArray>) {

    operator fun get(start: Int, end: Int): Int {
        val length = log2floor(end - start + 1)
        return min(table[start][length], table[end - pow2(length) + 1][length])
    }

    companion object {
        fun create(array: IntArray): MinimumRange {
            val depth = log2floor(array.size)
            val table = Array(array.size) { IntArray(depth + 1) }
            for (start in 0..array.lastIndex) {
                table[start][0] = array[start]
            }
            for (length in 1..depth) {
                for (start in 0..(array.size - pow2(length))) {
                    table[start][length] = min(table[start][length - 1], table[start + pow2(length - 1)][length - 1])
                }
            }

            return MinimumRange(table)
        }
    }
}