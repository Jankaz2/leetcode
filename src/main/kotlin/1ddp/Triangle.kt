package `1ddp`

class Triangle {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val dp = IntArray(triangle.last().size)

        for (row in triangle.reversed()) {
            for ((i, value) in row.withIndex()) {
                dp[i] = minOf(dp[i], dp[i + 1]) + value
            }
        }

        return dp[0]
    }
}
