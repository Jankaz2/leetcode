package graphs

class ShortestPathInBinaryMatrix {

    private val directions = listOf(
        Pair(1, 0), Pair(-1, 0), Pair(0, 1), Pair(0, -1),
        Pair(1, 1), Pair(-1, 1), Pair(-1, -1), Pair(1, -1),
    )

    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        if (grid[0][0] == 1) return -1

        val visited = mutableSetOf<Pair<Int, Int>>()
        val q = ArrayDeque<Triple<Int, Int, Int>>()

        q.add(Triple(0, 0, 1))
        visited.add(Pair(0, 0))

        while (q.isNotEmpty()) {
            val (r, c, moves) = q.removeFirst()

            if (r == grid.size - 1 && c == grid[0].size - 1) {
                return if (grid[r][c] == 0) moves else -1
            }

            for ((dr, dc) in directions) {
                val newRow = r + dr
                val newCol = c + dc

                if (newRow !in grid.indices ||
                    newCol !in grid[0].indices ||
                    grid[newRow][newCol] == 1 ||
                    Pair(newRow, newCol) in visited
                ) {
                    continue
                }

                q.add(Triple(newRow, newCol, moves + 1))
                visited.add(Pair(newRow, newCol))
            }
        }

        return -1
    }
}
