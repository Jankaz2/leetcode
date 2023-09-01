package dp_twodimensional

import kotlin.math.max

class LongestIncreasingPathInAMatrix {
    fun longestIncreasingPath(matrix: Array<IntArray>?): Int {
        if (matrix.isNullOrEmpty() || matrix[0].isEmpty()) return 0
        val cache = Array(matrix.size) { IntArray(matrix[0].size) }

        fun findSmallAround(i: Int, j: Int, previous: Int): Int {
            if (i !in matrix.indices || j !in matrix[0].indices || matrix[i][j] >= previous) return 0
            if (cache[i][j] > 0) return cache[i][j]

            val cur = matrix[i][j]
            cache[i][j] = 1 + maxOf(
                findSmallAround(i - 1, j, cur),
                findSmallAround(i + 1, j, cur),
                findSmallAround(i, j - 1, cur),
                findSmallAround(i, j + 1, cur)
            )

            return cache[i][j]
        }

        var max = 0
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                val length = findSmallAround(i, j, matrix[i][j])
                max = maxOf(length, max)
            }
        }
        return max
    }
}


class Solution {
    fun longestIncreasingPath(matrix: Array<IntArray>?): Int {
        if (matrix == null || matrix.size == 0 || matrix[0].size == 0) {
            return 0
        }
        val cache = Array(matrix.size) {
            IntArray(
                matrix[0].size
            )
        }
        var max = 0
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                val length = findSmallAround(i, j, matrix, cache, Int.MAX_VALUE)
                max = max(length.toDouble(), max.toDouble()).toInt()
            }
        }
        return max
    }

    private fun findSmallAround(i: Int, j: Int, matrix: Array<IntArray>, cache: Array<IntArray>, pre: Int): Int {
        // if out of bond OR current cell value larger than previous cell value.
        if (i < 0 || i >= matrix.size || j < 0 || j >= matrix[0].size || matrix[i][j] >= pre) {
            return 0
        }
        // if calculated before, no need to do it again
        return if (cache[i][j] > 0) {
            cache[i][j]
        } else {
            val cur = matrix[i][j]
            var tempMax = 0
            tempMax = max(findSmallAround(i - 1, j, matrix, cache, cur).toDouble(), tempMax.toDouble()).toInt()
            tempMax = max(findSmallAround(i + 1, j, matrix, cache, cur).toDouble(), tempMax.toDouble()).toInt()
            tempMax = max(findSmallAround(i, j - 1, matrix, cache, cur).toDouble(), tempMax.toDouble()).toInt()
            tempMax = max(findSmallAround(i, j + 1, matrix, cache, cur).toDouble(), tempMax.toDouble()).toInt()
            cache[i][j] = ++tempMax
            tempMax
        }
    }
}

fun main() {
    val solution = LongestIncreasingPathInAMatrix()
    solution.longestIncreasingPath(
        arrayOf(
            intArrayOf(3, 4, 5),
            intArrayOf(3, 2, 6),
            intArrayOf(2, 2, 1)
        )
    )
}
