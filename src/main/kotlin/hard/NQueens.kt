package hard

import java.lang.StringBuilder

class NQueens {

    fun solveNQueens(n: Int): List<List<String>> {
        val board = MutableList(n) { MutableList(n) { "." } }
        val result = mutableListOf<List<String>>()

        val columns = mutableSetOf<Int>()
        val positiveDiagonals = mutableSetOf<Int>() // row + col
        val negativeDiagonals = mutableSetOf<Int>() // row - col

        fun backtrack(row: Int) {
            if (row == n) {
                val copy = board.map { it.joinToString("") }
                result.add(copy)
                return
            }

            for (col in 0 until board[0].size) {
                if (col in columns || (row + col) in positiveDiagonals || (row - col) in negativeDiagonals) {
                    continue
                }

                board[row][col] = "Q"
                columns.add(col)
                positiveDiagonals.add(row + col)
                negativeDiagonals.add(row - col)

                backtrack(row + 1)

                board[row][col] = "."
                columns.remove(col)
                positiveDiagonals.remove(col)
                negativeDiagonals.remove(col)
            }
        }

        backtrack(0)
        return result
    }

}
