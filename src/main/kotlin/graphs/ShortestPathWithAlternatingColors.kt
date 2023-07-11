package graphs

class ShortestPathWithAlternatingColors {

    fun shortestAlternatingPaths(n: Int, redEdges: Array<IntArray>, blueEdges: Array<IntArray>): IntArray {
        val answer = IntArray(n) { -1 }
        val neighborsMap = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()

        // red is 1, blue is -1
        for ((src, dst) in redEdges) neighborsMap.getOrPut(src) { mutableListOf() }.add(Pair(dst, 1))
        for ((src, dst) in blueEdges) neighborsMap.getOrPut(src) { mutableListOf() }.add(Pair(dst, -1))

        fun bfs(target: Int): Int {
            val q = ArrayDeque<Triple<Int, Int, Int>>() // node, color, counter
            val visited = mutableSetOf<Pair<Int, Int>>() // node, color

            q.add(Triple(0, 1, 0))
            q.add(Triple(0, -1, 0))
            visited.add(Pair(0, 1))
            visited.add(Pair(0, -1))

            while (q.isNotEmpty()) {
                val (node, color, counter) = q.removeFirst()

                for ((nei, neiColor) in neighborsMap[node] ?: mutableListOf()) {
                    if (neiColor == color) continue
                    if (nei == target) return counter + 1

                    if (Pair(nei, neiColor) !in visited) {
                        q.add(Triple(nei, color, counter + 1))
                        visited.add(Pair(nei, neiColor))
                    }
                }
            }

            return -1
        }

        answer[0] = 0
        for (i in 1 until n) {
            answer[i] = bfs(i)
        }

        return answer
    }
}

fun main() {
    val redEdges = arrayOf(
        intArrayOf(2, 0),
        intArrayOf(4, 3),
        intArrayOf(4, 4),
        intArrayOf(3, 0),
        intArrayOf(1, 4)
    )

    val blueEdges = arrayOf(
        intArrayOf(2, 1),
        intArrayOf(4, 3),
        intArrayOf(3, 1),
        intArrayOf(3, 0),
        intArrayOf(1, 1),
        intArrayOf(2, 0),
        intArrayOf(0, 3),
        intArrayOf(3, 3),
        intArrayOf(2, 3)
    )

    val solution = ShortestPathWithAlternatingColors()
    solution.shortestAlternatingPaths(5, redEdges, blueEdges)
}
