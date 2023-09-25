package arrays_and_hashing

class GridGame {
    fun gridGame(grid: Array<IntArray>): Int {
        val n = grid[0].size
        val preRow1 = grid[0].copyOf()
        val preRow2 = grid[1].copyOf()

        for (i in 1 until n) {
            preRow1[i] += preRow1[i - 1]
            preRow2[i] += preRow2[i - 1]
        }

        var res = Int.MAX_VALUE
        for (i in 0 until n) {
            val top = preRow1.last() - preRow1[i]
            val bottom = if (i > 0) preRow2[i - 1] else 0
            val secondRobot = maxOf(top, bottom)
            res = minOf(res, secondRobot)
        }

        return res
    }
}

fun main() {
    val solution = GridGame()
    solution.gridGame(
        arrayOf(
            intArrayOf(2, 5, 4),
            intArrayOf(1, 5, 1)
        )
    )
}
