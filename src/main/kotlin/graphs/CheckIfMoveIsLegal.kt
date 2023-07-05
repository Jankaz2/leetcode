package graphs

class CheckIfMoveIsLegal {

    fun checkMove(board: Array<CharArray>, rMove: Int, cMove: Int, color: Char): Boolean {
        val directions = listOf(
            Pair(1, 0), Pair(-1, 0), Pair(0, 1), Pair(0, -1),
            Pair(1, 1), Pair(-1, 1), Pair(-1, -1), Pair(1, -1),
        )
        var length: Int

        for ((dr, dc) in directions) {
            var r = rMove
            var c = cMove
            length = 1

            while (true) {
                r += dr
                c += dc
                length++

                if (r !in board.indices || c !in board[0].indices || board[r][c] == '.') {
                    break
                }

                if (board[r][c] == color) {
                    if (length >= 3) {
                        return true
                    }

                    break
                }

            }
        }

        return false
    }

}

fun main() {
    val board: Array<CharArray> = arrayOf(
        charArrayOf('.', '.', 'W', '.', 'B', 'W', 'W', 'B'),
        charArrayOf('B', 'W', '.', 'W', '.', 'W', 'B', 'B'),
        charArrayOf('.', 'W', 'B', 'W', 'W', '.', 'W', 'W'),
        charArrayOf('W', 'W', '.', 'W', '.', '.', 'B', 'B'),
        charArrayOf('B', 'W', 'B', 'B', 'W', 'W', 'B', '.'),
        charArrayOf('W', '.', 'W', '.', '.', 'B', 'W', 'W'),
        charArrayOf('B', '.', 'B', 'B', '.', '.', 'B', 'B'),
        charArrayOf('.', 'W', '.', 'W', '.', 'W', '.', 'W')
    )

    val solution = CheckIfMoveIsLegal()
    solution.checkMove(board, 5, 4, 'W')
}
