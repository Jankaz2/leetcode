package medium

class Search2DMatrix {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val numRows = matrix.size
        val numCols = matrix.first().size

        var left = 0
        var right = numRows * numCols - 1

        while (left <= right) {
            val mid = left + (right - left) / 2
            val row = mid / numCols
            val col = mid % numCols
            val midValue = matrix[row][col]

            if (midValue == target) {
                return true
            } else if (midValue < target) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return false
    }

}

fun main() {
    val solution = Search2DMatrix()
    println(
        solution.searchMatrix(
            arrayOf(
                intArrayOf(1, 3, 5, 7),
                intArrayOf(10, 11, 16, 20),
                intArrayOf(23, 30, 34, 60)
            ),
            3
        ),
    )

    println(
        solution.searchMatrix(
            arrayOf(
                intArrayOf(1, 3, 5, 7),
                intArrayOf(10, 11, 16, 20),
                intArrayOf(23, 30, 34, 60)
            ),
            13
        ),
    )
}
