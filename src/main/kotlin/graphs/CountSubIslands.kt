package graphs

class CountSubIslands {
    fun countSubIslands(grid1: Array<IntArray>, grid2: Array<IntArray>): Int {
        var counter = 0
        var res: Int

        fun dfs(r: Int, c: Int) {
            if (r !in grid1.indices || c !in grid1[0].indices || grid2[r][c] == 0) {
                return
            }

            if (grid1[r][c] == 0) {
                res = 0
            }

            grid2[r][c] = 0
            dfs(r + 1, c)
            dfs(r - 1, c)
            dfs(r, c + 1)
            dfs(r, c - 1)
        }

        for (r in grid2.indices) {
            for (c in grid2[0].indices) {
                if (grid2[r][c] == 1 && grid1[r][c] == 1) {
                    res = 1
                    dfs(r, c)
                    counter += res
                }
            }
        }

        return counter
    }
}

fun main() {
    val grid1 = arrayOf(
        intArrayOf(1, 0, 1, 0, 1),
        intArrayOf(1, 1, 1, 1, 1),
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(1, 1, 1, 1, 1),
        intArrayOf(1, 0, 1, 0, 1)
    )

    val grid2 = arrayOf(
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(1, 1, 1, 1, 1),
        intArrayOf(0, 1, 0, 1, 0),
        intArrayOf(0, 1, 0, 1, 0),
        intArrayOf(1, 0, 0, 0, 1)
    )


    val solution = CountSubIslands()
    println(solution.countSubIslands(grid1, grid2))
}
