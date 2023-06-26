package graphs

class RottingOranges {
    fun orangesRotting(grid: Array<IntArray>): Int {
        var time = 0
        var fresh = 0
        val q = ArrayDeque<Pair<Int, Int>>()
        val directions = listOf(Pair(0, 1), Pair(0, -1), Pair(1, 0), Pair(-1, 0))

        for (i in grid.indices) {
            for (j in grid[0].indices) {
                when (grid[i][j]) {
                    1 -> fresh++
                    2 -> q.add(Pair(i, j))
                }
            }
        }


        while (q.isNotEmpty() && fresh > 0) {
            for (i in 0 until q.size) {
                val (r, c) = q.removeFirst()

                for ((dr, dc) in directions) {
                    val row = r + dr
                    val col = c + dc

                    if (row !in grid.indices || col !in grid[0].indices || grid[row][col] != 1) {
                        continue
                    }

                    grid[row][col] = 2
                    q.add(Pair(row, col))
                    fresh--
                }
            }

            time++
        }


        return if (fresh <= 0) time else -1
    }
}

fun main() {
    val solution = RottingOranges()
    val grid = arrayOf(
        intArrayOf(2, 1, 1),
        intArrayOf(1, 1, 0),
        intArrayOf(0, 1, 1)
    )

    val res = solution.orangesRotting(grid)
    println(res)
}
