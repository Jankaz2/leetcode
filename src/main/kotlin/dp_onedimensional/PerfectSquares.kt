package dp_onedimensional

class PerfectSquares {

    fun numSquares(n: Int): Int {
        val dp = IntArray(n + 1) { n }
        dp[0] = 0

        for (target in 1 .. n) {
            for (s in 1 .. target) {
                val squared = s * s
                if (squared > target) break
                dp[target] = minOf(dp[target], 1 + dp[target - squared])
            }
        }

        return dp[n]
    }
}

fun main() {
    val solution = PerfectSquares()
    solution.numSquares(12)
}
