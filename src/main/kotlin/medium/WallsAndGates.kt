package medium

class WallsAndGates {
    fun wallsAndGates(rooms: Array<IntArray>): Array<IntArray> {
        val visited = mutableSetOf<Pair<Int, Int>>()
        val q = ArrayDeque<Pair<Int, Int>>()
        var distance = 0

        fun addRoom(row: Int, col: Int) {
            if (row !in rooms.indices || col !in rooms[0].indices || rooms[row][col] == -1 || visited.contains(
                    Pair(
                        row,
                        col
                    )
                )
            ) return
            visited.add(Pair(row, col))
            q.add(Pair(row, col))
        }

        for (r in rooms.indices) {
            for (c in rooms[0].indices) {
                if (rooms[r][c] == 0) {
                    q.add(Pair(r, c))
                    visited.add(Pair(r, c))
                }
            }
        }

        while (q.isNotEmpty()) {
            for (i in 0 until q.size) {
                val (row, col) = q.removeFirst()
                rooms[row][col] = distance
                addRoom(row + 1, col)
                addRoom(row - 1, col)
                addRoom(row, col + 1)
                addRoom(row, col - 1)
            }

            distance++
        }

        return rooms
    }

    fun print(arr: Array<IntArray>) {
        for (r in arr.indices) {
            for (c in arr[0].indices) {
                print("${arr[r][c]} | ")
            }
            println()
        }

        println("----------------------------")
    }
}

fun main() {
    val solution = WallsAndGates()
    val rooms = arrayOf(
        intArrayOf(Int.MAX_VALUE, -1, 0, Int.MAX_VALUE),
        intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE, Int.MAX_VALUE, -1),
        intArrayOf(Int.MAX_VALUE, -1, Int.MAX_VALUE, -1),
        intArrayOf(0, -1, Int.MAX_VALUE, Int.MAX_VALUE),
    )

    solution.print(rooms)
    val res = solution.wallsAndGates(rooms)
    solution.print(res)
}
