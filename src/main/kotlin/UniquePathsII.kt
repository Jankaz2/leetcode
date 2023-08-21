class UniquePathsII {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val ROWS = obstacleGrid.size
        val COLS = obstacleGrid[0].size
        val grid = Array(ROWS) { IntArray(COLS) }

        for (i in 0 until ROWS)
            if (obstacleGrid[i][0] != 1) grid[i][0] = 1 else break

        for (i in 0 until COLS)
            if (obstacleGrid[0][i] != 1) grid[0][i] = 1 else break

        for (i in 1 until ROWS) {
            for (j in 1 until COLS) {
                if (obstacleGrid[i][j] != 1) {
                    val left = grid[i][j - 1]
                    val top = grid[i - 1][j]

                    grid[i][j] = left + top
                }
            }
        }

        return grid[ROWS - 1][COLS - 1]
    }

    fun uniquePathsWithObstaclesSingleDP(obstacleGrid: Array<IntArray>): Int {
        val ROWS = obstacleGrid.size
        val COLS = obstacleGrid[0].size
        val dp = IntArray(obstacleGrid[0].size)
        dp[0] = 1

        for (r in 0 until ROWS) {
            for (c in 0 until COLS) {
                if (obstacleGrid[r][c] == 1) {
                    dp[c] = 0
                } else if (c > 0) {
                    dp[c] += dp[c - 1]
                }
            }
        }

        return dp.last()
    }
}
