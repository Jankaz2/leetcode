package graphs

class ShortestBridge {
    private val dirs = listOf(
        Pair(1, 0), Pair(-1, 0), Pair(0, 1), Pair(0, -1)
    )

    private fun dfs(
        r: Int,
        c: Int,
        grid: Array<IntArray>,
        visited: Array<BooleanArray>,
        onesCoordinates: ArrayDeque<Pair<Int, Int>>
    ) {
        if (r !in grid.indices || c !in grid[0].indices || grid[r][c] == 0 || visited[r][c]) {
            return
        }

        visited[r][c] = true
        onesCoordinates.add(Pair(r, c))

        for ((dr, dc) in dirs) {
            dfs(r + dr, c + dc, grid, visited, onesCoordinates)
        }
    }

    fun shortestBridge(grid: Array<IntArray>): Int {
        val coordinates = ArrayDeque<Pair<Int, Int>>()
        val visited = Array(grid.size) { BooleanArray(grid[0].size) }

        outer@ for (r in grid.indices) {
            for (c in grid[0].indices) {
                if (grid[r][c] == 1) {
                    dfs(r, c, grid, visited, coordinates)
                    break@outer
                }
            }
        }

        var result = 0

        while (coordinates.isNotEmpty()) {

            repeat(coordinates.size) {
                val (r, c) = coordinates.removeFirst()

                for ((dr, dc) in dirs) {
                    val newRow = dr + r
                    val newCol = dc + c

                    if (newRow in grid.indices && newCol in grid[0].indices && !visited[newRow][newCol]) {
                        if (grid[newRow][newCol] == 1) {
                            return result
                        }

                        coordinates.add(Pair(newRow, newCol))
                        visited[newRow][newCol] = true
                    }
                }
            }

            result++
        }

        return result
    }
}

fun main() {
    val solution = ShortestBridge()
    val input = arrayOf(
        intArrayOf(0, 0, 0, 0, 0, 0, 0),
        intArrayOf(1, 0, 0, 0, 0, 0, 0),
        intArrayOf(1, 0, 0, 0, 0, 0, 0),
        intArrayOf(1, 1, 0, 0, 0, 0, 0),
        intArrayOf(0, 1, 0, 1, 1, 1, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0)
    )

    println(solution.shortestBridge(input))
}

