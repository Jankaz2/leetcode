package medium

class NumberOfIslands {
    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) return 0
        val rows = grid.size
        val cols = grid[0].size
        var islands = 0
        val visited = mutableSetOf<Pair<Int, Int>>()

        fun bfs(r: Int, c: Int) {
            val q = ArrayDeque<Pair<Int, Int>>()
            val directions = listOf(Pair(1, 0), Pair(-1, 0), Pair(0, 1), Pair(0, -1))
            q.add(Pair(r, c))
            visited.add(Pair(r, c))

            while (q.isNotEmpty()) {
                val (row, col) = q.removeFirst()

                for ((dr, dc) in directions) {
                    val newRow = row + dr
                    val newCol = col + dc
                    val newNode = Pair(newRow, newCol)

                    if (
                        newRow in 0 until rows &&
                        newCol in 0 until cols &&
                        grid[newRow][newCol] == '1' &&
                        newNode !in visited
                    ) {
                        visited.add(newNode)
                        q.add(newNode)
                    }
                }
            }

        }

        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (grid[r][c] == '1' && Pair(r, c) !in visited) {
                    bfs(r, c)
                    islands++
                }
            }
        }

        return islands
    }

    fun numOfIslandsDFS(grid: Array<CharArray>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) return 0

        var islands = 0

        for (r in grid.indices) {
            for (c in 0 until grid[0].size) {
                if (grid[r][c] == '1') {
                    dfs(grid, r, c)
                    islands++
                }
            }
        }

        return islands
    }

    private fun dfs(grid: Array<CharArray>, r: Int, c: Int) {
        if (r !in grid.indices || c !in grid[0].indices || grid[r][c] != '1') return
        grid[r][c] = '0'

        dfs(grid, r + 1, c)
        dfs(grid, r - 1, c)
        dfs(grid, r, c + 1)
        dfs(grid, r, c - 1)
    }
}
