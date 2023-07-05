package graphs

import java.util.*


class FindClosestNodeToGivenTwoNodes {

    fun closestMeetingNode(edges: IntArray, node1: Int, node2: Int): Int {
        fun bfs(src: Int, distMap: MutableMap<Int, Int>) {
            val q: Queue<Pair<Int, Int>> = LinkedList()
            q.add(Pair(src, 0))
            distMap[src] = 0

            while (q.isNotEmpty()) {
                val (node, dist) = q.remove()

                if (node != -1 && edges[node] !in distMap) {
                    q.add(Pair(edges[node], dist + 1))
                    distMap[edges[node]] = dist + 1
                }
            }
        }

        val node1DistanceMap = mutableMapOf<Int, Int>()
        val node2DistanceMap = mutableMapOf<Int, Int>()
        bfs(node1, node1DistanceMap)
        bfs(node2, node2DistanceMap)

        var res = -1
        var resDistance = Int.MAX_VALUE

        for (e in edges.indices) {
            if (e in node1DistanceMap && e in node2DistanceMap) {
                val distance = maxOf(node1DistanceMap[e]!!, node2DistanceMap[e]!!)
                if (distance < resDistance) {
                    res = e
                    resDistance = distance
                }
            }
        }

        return res
    }
}

fun main() {
    val solution = FindClosestNodeToGivenTwoNodes()
    solution.closestMeetingNode(intArrayOf(2, 2, 3, -1), 0, 1)
}
