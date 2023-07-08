package graphs

class NumberOfEnclaves {
    private val directions = listOf(
        Pair(1, 0), Pair(-1, 0), Pair(0, 1), Pair(0, -1)
    )

    fun numEnclaves(grid: Array<IntArray>): Int {
        val visited = mutableSetOf<Pair<Int, Int>>()
        var land = 0
        var borderLand = 0
        var result = 0

        fun dfs(r: Int, c: Int): Int {
            if (r !in grid.indices || c !in grid[0].indices || grid[r][c] == 0 || Pair(r, c) in visited) {
                return 0
            }

            visited.add(Pair(r, c))

            return 1 + dfs(r + 1, c) + dfs(r - 1, c) + dfs(r, c + 1) + dfs(r, c - 1)
        }

        for (r in grid.indices) {
            for (c in grid[0].indices) {
                land += grid[r][c]
                if (Pair(r, c) !in visited && grid[r][c] == 1 && r in arrayOf(0, grid.lastIndex) && c in arrayOf(0, grid[0].lastIndex)) {
                    borderLand += dfs(r, c)
                }
            }
        }

        return land - borderLand
    }
}

fun main() {
    val solution = NumberOfEnclaves()
    val input: Array<IntArray> = arrayOf(
        intArrayOf(0, 0, 0, 0),
        intArrayOf(1, 0, 1, 0),
        intArrayOf(0, 1, 1, 0),
        intArrayOf(0, 0, 0, 0)
    )

    solution.numEnclaves(input)
}
