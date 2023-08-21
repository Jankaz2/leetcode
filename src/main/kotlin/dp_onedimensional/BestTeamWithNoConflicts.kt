package dp_onedimensional

class BestTeamWithNoConflicts {
    fun bestTeamScore(scores: IntArray, ages: IntArray): Int {
        val sorted = scores.zip(ages).sortedWith(compareBy({ it.first }, { it.second }))
        val dp = IntArray(scores.size) { index -> sorted[index].first } // dp of scores

        for (i in scores.indices) {
            for (j in 0 until i) {
                if (sorted[i].second >= sorted[j].second) { // comparing ages
                    dp[i] = maxOf(dp[i], dp[j] + sorted[i].first)
                }
            }
        }

        return dp.max()
    }
}

fun main() {
    val solution = BestTeamWithNoConflicts()
    solution.bestTeamScore(
        intArrayOf(1, 2, 3, 5),
        intArrayOf(8, 9, 10, 1)
    )
}
