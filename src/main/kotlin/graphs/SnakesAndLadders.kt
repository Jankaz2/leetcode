package graphs

class SnakesAndLadders {
    fun snakesAndLadders(board: Array<IntArray>): Int {
        board.reverse()

        fun getCoordinates(square: Int): Pair<Int, Int> {
            val r = (square - 1) / board.size
            var c = (square - 1) % board.size
            if (r % 2 == 1) {
                c = board.size - 1 - c
            }

            return Pair(r, c)
        }

        val result = board.size * board.size
        val visited = mutableSetOf<Int>()
        val q = ArrayDeque<Pair<Int, Int>>()
        q.add(Pair(1, 0))
        while (q.isNotEmpty()) {
            val (square, moves) = q.removeFirst()

            for (i in 1..6) {
                var nextSquare = square + i
                val (r, c) = getCoordinates(nextSquare)
                if (board[r][c] != -1) {
                    nextSquare = board[r][c]
                }
                if (nextSquare == result) {
                    return moves + 1
                }
                if (nextSquare !in visited) {
                    visited.add(nextSquare)
                    q.add(Pair(nextSquare, moves + 1))
                }
            }
        }

        return -1
    }
}
