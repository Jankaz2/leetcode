package dp_twodimensional

class BurstBalloons {
    fun maxCoins(nums: IntArray): Int {
        val numsWithBoundries = intArrayOf(1) + nums + intArrayOf(1)
        val cache = mutableMapOf<Pair<Int, Int>, Int>()

        fun dfs(l: Int, r: Int): Int {
            if (l > r) return 0
            if (Pair(l, r) in cache) return cache[Pair(l, r)]!!

            for (i in l..r) {
                var coins = numsWithBoundries[l - 1] * numsWithBoundries[i] * numsWithBoundries[r + 1]
                coins += dfs(l, i - 1) + dfs(i + 1, r)
                cache[Pair(l, r)] = maxOf(cache[Pair(l, r)] ?: 0, coins)
            }

            return cache[Pair(l, r)]!!
        }

        return dfs(1, numsWithBoundries.lastIndex - 1)
    }
}

fun main() {
    val solution = BurstBalloons()
    solution.maxCoins(intArrayOf(3, 1, 5, 8))
}
