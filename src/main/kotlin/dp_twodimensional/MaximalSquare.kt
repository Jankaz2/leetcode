package dp_twodimensional

class MaximalSquare {
    fun maximalSquare(matrix: Array<CharArray>): Int {
        val dp = Array(matrix.size + 1) { IntArray(matrix[0].size + 1) }
        var maxSide = 0

        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = 1 + minOf(dp[i][j], dp[i + 1][j], dp[i][j + 1])
                    maxSide = maxOf(dp[i + 1][j + 1], maxSide)
                }
            }
        }

        return maxSide * maxSide
    }
}
