package graphs

class NumberOfClosedIslands {
    fun closedIsland(grid: Array<IntArray>): Int {
        val visited = mutableSetOf<Pair<Int, Int>>()
        var counter = 0

        fun dfs(r: Int, c: Int): Int {
            if (r !in grid.indices || c !in grid[0].indices) {
                return 0
            }

            if (grid[r][c] == 1 || Pair(r, c) in visited) {
                return 1
            }

            visited.add(Pair(r, c))

            return listOf(
                dfs(r + 1, c),
                dfs(r - 1, c),
                dfs(r, c + 1),
                dfs(r, c - 1)
            ).min()
        }

        for (r in grid.indices) {
            for (c in grid[0].indices) {
                if (grid[r][c] == 0 && Pair(r, c) !in visited) {
                    counter += dfs(r, c)
                }
            }
        }
        return counter
    }
}

fun main() {
    val solution = NumberOfClosedIslands()
    val input: Array<IntArray> = arrayOf(
        intArrayOf(1, 1, 1, 1, 1, 1, 1, 0),
        intArrayOf(1, 0, 0, 0, 0, 1, 1, 0),
        intArrayOf(1, 0, 1, 0, 1, 1, 1, 0),
        intArrayOf(1, 0, 0, 0, 0, 1, 0, 1),
        intArrayOf(1, 1, 1, 1, 1, 1, 1, 0)
    )


    solution.closedIsland(input)
}

