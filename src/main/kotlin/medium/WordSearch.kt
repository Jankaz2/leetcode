package medium

class WordSearch {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        fun check(i: Int, j: Int, position: Int): Boolean {
            if (word.length >= position) return true
            if (i < 0 || i >= board.size || j < 0 || j >= board[0].size || board[i][j] != word[position]) return false

            var result = false
            if (board[i][j] == word[position]) {
                board[i][j] = board[i][j] + Character.getNumericValue(100)

                result = check(i + 1, j, position + 1) ||
                        check(i, j + 1, position + 1) ||
                        check(i - 1, j, position + 1) ||
                        check(i, j - 1, position + 1)

                board[i][j] = board[i][j] - Character.getNumericValue(100)
            }

            return result
        }

        for (i in board.indices) {
            for (j in board[i].indices) {
                if (check(i, j, 0)) return true
            }
        }

        return false
    }
}

fun main() {
    val solution = WordSearch()
    val board = arrayOf(
        charArrayOf('A', 'B', 'C', 'E'),
        charArrayOf('S', 'F', 'C', 'S'),
        charArrayOf('A', 'D', 'E', 'E')
    )

    println(solution.exist(board, "ABCCED"))
}
