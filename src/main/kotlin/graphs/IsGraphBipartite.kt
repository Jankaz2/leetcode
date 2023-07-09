package graphs

import java.util.*
import kotlin.collections.ArrayDeque

class IsGraphBipartite {

    enum class Color {
        RED,
        BLUE,
        UNVISITED
    }

    fun isBipartite(graph: Array<IntArray>): Boolean {
        val colors = Array(graph.size) { 0 }

        for (n in graph.indices) {
            if (colors[n] != 0) continue

            val q = ArrayDeque<Int>()
            q.add(n)
            colors[n] = 1

            while (q.isNotEmpty()) {
                val current = q.removeFirst()
                val neighbors = graph[current]

                for (nei in neighbors) {
                    if (colors[nei] == 0) {
                        colors[nei] = -1 * colors[current]
                        q.add(nei)
                    } else if(colors[nei] == colors[current]) {
                        return false
                    }
                }
            }
        }

        return true
    }

}

fun main() {
    val graph = arrayOf(
        intArrayOf(1, 3),
        intArrayOf(0, 2),
        intArrayOf(1, 3),
        intArrayOf(0, 2),
    )

    val solution = IsGraphBipartite()
    solution.isBipartite(graph)
}
