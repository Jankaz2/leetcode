package medium

class SurroundedRegion {
    fun solve(board: Array<CharArray>): Unit {
        fun dfs(r: Int, c: Int) {
            if (r !in board.indices || c !in board[0].indices) return
            if (board[r][c] == 'X') return

            board[r][c] = '#'

            dfs(r + 1, c)
            dfs(r - 1, c)
            dfs(r, c + 1)
            dfs(r, c - 1)
        }

        for (r in board.indices) {
            for (c in 0 until board[0].size) {
                if ((r == 0 || r == board.lastIndex || c == 0 || c == board[0].lastIndex) && board[r][c] == 'O') {
                    dfs(r, c)
                }
            }
        }

        for (r in board.indices) {
            for (c in 0 until board[0].size) {
                when (board[r][c]) {
                    '#' -> board[r][c] = 'O'
                    'O' -> board[r][c] = 'X'
                }
            }
        }
    }
}

fun main() {
    val solution = SurroundedRegion()
    val board = arrayOf(
        charArrayOf('X', 'X', 'X', 'X'),
        charArrayOf('X', 'O', 'O', 'X'),
        charArrayOf('X', 'X', 'O', 'X'),
        charArrayOf('X', 'O', 'X', 'X'),
    )
    solution.solve(board)

}


