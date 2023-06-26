package graphs

import java.util.*

class PacificAtlanticWaterFlow {
    fun pacificAtlantic(matrix: Array<IntArray>?): List<IntArray>? {
        val res: MutableList<IntArray> = LinkedList()
        if (matrix.isNullOrEmpty() || matrix[0].isEmpty()) {
            return res
        }

        val pacificVisited = Array(matrix.size) { BooleanArray(matrix[0].size) }
        val atlanticVisited = Array(matrix.size) { BooleanArray(matrix[0].size) }

        fun dfs(x: Int, y: Int, height: Int, visited: Array<BooleanArray>) {
            if (x !in matrix.indices || y !in matrix[0].indices || matrix[x][y] < height || visited[x][y]) return

            visited[x][y] = true

            dfs(x - 1, y, matrix[x][y], visited)
            dfs(x + 1, y, matrix[x][y], visited)
            dfs(x, y - 1, matrix[x][y], visited)
            dfs(x, y + 1, matrix[x][y], visited)
        }

        for (i in matrix.indices) {
            dfs(i, 0, Int.MIN_VALUE, pacificVisited)
            dfs(i, matrix[0].size - 1, Int.MIN_VALUE, atlanticVisited)
        }

        for (i in 0 until matrix[0].size) {
            dfs(0, i, Int.MIN_VALUE, pacificVisited)
            dfs(matrix.lastIndex, i, Int.MIN_VALUE, atlanticVisited)
        }

        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                if (atlanticVisited[i][j] && pacificVisited[i][j]) {
                    res.add(intArrayOf(i, j))
                }
            }
        }

        return res
    }
}

fun main() {
    val solution = PacificAtlanticWaterFlow()
    val input = listOf(
        listOf(1, 2, 2, 3, 5),
        listOf(3, 2, 3, 4, 4),
        listOf(2, 4, 5, 3, 1),
        listOf(6, 7, 1, 4, 5),
        listOf(5, 1, 1, 2, 4)
    )

    val arr: Array<IntArray> = input.map { it.toIntArray() }.toTypedArray()
    solution.pacificAtlantic(arr)
}
