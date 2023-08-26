package dp_twodimensional

class LastStoneWeightII {
    fun lastStoneWeightII(stones: IntArray): Int {
        val total = stones.sum()

        val maxWeight = total / 2

        val current = IntArray(maxWeight + 1) { 0 }

        for (v in stones) {
            for (w in maxWeight downTo 0) {
                if (w - v >= 0) {
                    current[w] = maxOf(v + current[w - v], current[w])
                }
            }
        }

        return total - 2 * current[maxWeight]
    }
}

fun main() {
    val solution = LastStoneWeightII()
    solution.lastStoneWeightII(intArrayOf(2, 7, 4, 1, 8, 1))
}
