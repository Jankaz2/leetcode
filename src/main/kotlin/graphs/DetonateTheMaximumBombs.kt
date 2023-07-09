package graphs

import kotlin.math.*

class DetonateTheMaximumBombs {
    private fun calculateDistance(p1: Pair<Int, Int>, p2: Pair<Int, Int>): Double {
        val n1 = (p1.first - p2.first).toDouble().pow(2.0)
        val n2 = (p1.second - p2.second).toDouble().pow(2.0)

        return sqrt(n1 + n2)
    }

    fun maximumDetonation(bombs: Array<IntArray>): Int {
        var max = Int.MIN_VALUE

        fun bfs(x: Int, y: Int, r: Int, index: Int): Int {
            val queue = ArrayDeque<Triple<Int, Int, Int>>() // x, y, r
            val visited = mutableSetOf<Triple<Int, Int, Int>>() // x, y, index
            var counter = 1

            queue.add(Triple(x, y, r))
            visited.add(Triple(x, y, index))

            while (queue.isNotEmpty()) {
                val (xx, yy, rr) = queue.removeFirst()

                bombs.forEachIndexed { idx, (x1, y1, r1) ->
                    if (Triple(x1, y1, idx) !in visited) {
                        val distance = calculateDistance(Pair(xx, yy), Pair(x1, y1))

                        if (distance <= rr) {
                            visited.add(Triple(x1, y1, idx))
                            queue.add(Triple(x1, y1, r1))
                            counter++
                        }
                    }
                }
            }

            return counter
        }

        bombs.forEachIndexed { index, (x, y, r) ->
            max = maxOf(max, bfs(x, y, r, index))
        }

        return max
    }
}

fun main() {
    val solution = DetonateTheMaximumBombs()
    val bombs = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(2, 3, 1),
        intArrayOf(3, 4, 2),
        intArrayOf(4, 5, 3),
        intArrayOf(5, 6, 4),
    )

    solution.maximumDetonation(bombs)
}
