package medium

class ValidSudoku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val columns = Array(9) { HashSet<Int>() }
        val rows = Array(9) { HashSet<Int>() }
        val subBoxes = arrayOf(
            arrayOf(HashSet<Int>(), HashSet<Int>(), HashSet<Int>()),
            arrayOf(HashSet<Int>(), HashSet<Int>(), HashSet<Int>()),
            arrayOf(HashSet<Int>(), HashSet<Int>(), HashSet<Int>())
        )
        for (i in 0 until 9) {
            for (j in 0 until 9) {

                if (!board[i][j].isDigit()) continue
                val value = Character.getNumericValue(board[i][j])

                if (value in columns[i]) return false
                columns[i].add(value)

                if (value in rows[j]) return false
                rows[j].add(value)

                if (value in subBoxes[j / 3][i / 3]) return false
                subBoxes[j / 3][i / 3].add(value)
            }
        }
        return true
    }
}

fun main() {
    val solution = ValidSudoku()
    val board = arrayOf(
        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )
    println(solution.isValidSudoku(board))
}
