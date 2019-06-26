import com.falcinspire.hacklib.combinatorics.BitsetCombination
import org.junit.Test

class CombinationGeneratorTest {
    @Test
    fun tryCombinations() {
        val size = 4
        val listener = BitsetCombination(size) {
            println(it)
        }
        combinations(size, 2, listener)
    }
}