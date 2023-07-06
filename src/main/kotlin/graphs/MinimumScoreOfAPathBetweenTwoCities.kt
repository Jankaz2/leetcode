package graphs

class MinimumScoreOfAPathBetweenTwoCities {

    fun minScore(n: Int, roads: Array<IntArray>): Int {
        val neiMap = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
        val visited = mutableSetOf<Int>()
        val q = ArrayDeque<Int>()

        for ((source, destination, distance) in roads) {
            neiMap.getOrPut(source) { mutableListOf() }.add(Pair(destination, distance))
            neiMap.getOrPut(destination) { mutableListOf() }.add(Pair(source, distance))
        }

        var min = Int.MAX_VALUE
        q.add(1)
        visited.add(1)

        while (q.isNotEmpty()) {
            val curr = q.removeFirst()

            for ((node, distance) in neiMap[curr]!!) {
                min = minOf(min, distance)
                if (node !in visited) {
                    visited.add(node)
                    q.add(node)
                }
            }
        }

        return min
    }
}

fun main() {

    val inp2 = arrayOf(
        intArrayOf(1, 2, 9),
        intArrayOf(2, 3, 6),
        intArrayOf(2, 4, 5),
        intArrayOf(1, 4, 7)
    )
    val solution = MinimumScoreOfAPathBetweenTwoCities()
    solution.minScore(4, inp2)
}
