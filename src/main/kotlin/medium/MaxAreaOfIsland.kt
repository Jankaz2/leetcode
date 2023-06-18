package medium

class MaxAreaOfIsland {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var max = 0

        fun dfs(r: Int, c: Int): Int {
            if (r !in grid.indices || c !in grid[0].indices || grid[r][c] != 1) return 0

            grid[r][c] = 2

            return 1 + dfs(r + 1, c) + dfs(r - 1, c) + dfs(r, c + 1) + dfs(r, c - 1)
        }

        for (r in grid.indices) {
            for (c in 0 until grid[0].size) {
                if (grid[r][c] == 1) {
                    max = max.coerceAtLeast(dfs(r, c))
                }
            }
        }

        return max
    }
}

fun main() {
    val input = arrayOf(
        intArrayOf(0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
        intArrayOf(0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
        intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0),
        intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0)
    )

    val solution = MaxAreaOfIsland()
    println(solution.maxAreaOfIsland(input))
}
