package graphs

import java.util.*
import kotlin.math.abs

class AsFarFromLandAsPossible {

    private val directions = listOf(Pair(1, 0), Pair(-1, 0), Pair(0, 1), Pair(0, -1))

    fun maxDistance(grid: Array<IntArray>): Int {
        val q: Queue<Triple<Int, Int, Int>> = LinkedList()
        val visited = Array(grid.size) { BooleanArray(grid[0].size) }

        for (r in grid.indices) {
            for (c in grid[0].indices) {
                if (grid[r][c] == 1) {
                    visited[r][c] = true
                    q.add(Triple(r, c, 0))
                }
            }
        }

        if (q.isEmpty() || q.size == grid.size * grid[0].size) {
            return -1
        }

        var maxDistance = Int.MIN_VALUE
        while (q.isNotEmpty()) {
            val (r, c, dist) = q.remove()
            maxDistance = maxOf(maxDistance, dist)

            for ((dr, dc) in directions) {
                val newRow = dr + r
                val newCol = dc + c

                if (newRow in grid.indices && newCol in grid[0].indices
                    && !visited[newRow][newCol] && grid[newRow][newCol] == 0) {
                    visited[newRow][newCol] = true
                    q.add(Triple(newRow, newCol, dist + 1))
                }
            }
        }

        return maxDistance
    }

}

fun main() {
    val grid = arrayOf(
        intArrayOf(1, 0, 1),
        intArrayOf(0, 0, 0),
        intArrayOf(1, 0, 1)
    )
    val solution = AsFarFromLandAsPossible()
    solution.maxDistance(grid)
}
