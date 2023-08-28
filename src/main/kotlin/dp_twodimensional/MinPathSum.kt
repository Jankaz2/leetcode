package dp_twodimensional

class MinPathSum {
    fun minPathSum(grid: Array<IntArray>): Int {
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (i == 0 && j == 0) continue
                if (i != 0 && j != 0) {
                    grid[i][j] += minOf(grid[i - 1][j], grid[i][j - 1])
                } else if (i != 0) {
                    grid[i][j] += grid[i - 1][j]
                } else {
                    grid[i][j] += grid[i][j - 1]
                }
            }
        }
        return grid[grid.size - 1][grid[0].size - 1]
    }
}
