package `1ddp`

import toIntArray

class MinimumCostForTickets {
    fun mincostTickets(days: IntArray, costs: IntArray): Int {
        val dp = (0..days.last()).toList().map { Int.MAX_VALUE }.toIntArray()
        dp[0] = 0

        for (day in 1..days.last()) {
            if (day !in days) {
                dp[day] = dp[day - 1]
                continue
            }

            dp[day] = minOf(
                dp[day - 1] + costs[0],
                dp[maxOf(0, day - 7)] + costs[1],
                dp[maxOf(0, day - 30)] + costs[2]
            )
        }

        return dp.last()
    }
}

fun main() {
    val solution = MinimumCostForTickets()
    println(solution.mincostTickets(intArrayOf(1, 4, 6, 7, 8, 20), intArrayOf(2, 7, 15)))
}
