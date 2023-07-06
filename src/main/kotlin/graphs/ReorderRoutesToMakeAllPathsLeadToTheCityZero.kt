package graphs

import java.util.LinkedList
import java.util.Queue

class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    data class Connection(val node: Int, val reversed: Boolean)

    fun minReorder(n: Int, connections: Array<IntArray>): Int {
        var ans = 0
        val edges = getEdgesFrom(connections)
        val q: Queue<Int> = LinkedList()
        val visited = mutableSetOf<Int>()

        visited.add(0); q.add(0)

        while (q.isNotEmpty()) {
            repeat(q.size) {
                val current = q.remove()

                for ((node, reversed) in edges[current]!!) {
                    if (node in visited) continue
                    if (reversed) ans++

                    visited.add(node)
                    q.add(node)
                }
            }
        }

        return ans
    }

    private fun getEdgesFrom(connections: Array<IntArray>): MutableMap<Int, MutableList<Connection>> {
        val edges = mutableMapOf<Int, MutableList<Connection>>()
        for ((source, destination) in connections) {
            edges.getOrPut(source) { mutableListOf() }.add(Connection(destination, true))
            edges.getOrPut(destination) { mutableListOf() }.add(Connection(source, false))
        }

        return edges
    }
}

class ReorderRoutesToMakeAllPathsLeadToTheCityZeroDFS {
    fun minReorder(n: Int, connections: Array<IntArray>): Int {
        val edges = connections.map { it[0] to it[1] }.toSet()
        val neighbors = (0 until n).associateWith { mutableListOf<Int>() }
        val visit = mutableSetOf<Int>()
        var changes = 0

        for ((a, b) in connections) {
            neighbors[a]!!.add(b)
            neighbors[b]!!.add(a)
        }

        fun dfs(city: Int) {
            for (neighbor in neighbors[city]!!) {
                if (neighbor in visit) {
                    continue
                }

                if ((neighbor to city) !in edges) {
                    changes++
                }

                visit.add(neighbor)
                dfs(neighbor)
            }
        }

        visit.add(0)
        dfs(0)
        return changes
    }
}

fun main() {
    val solution = ReorderRoutesToMakeAllPathsLeadToTheCityZero()
    val solutionDFS = ReorderRoutesToMakeAllPathsLeadToTheCityZeroDFS()
    val connections = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 3),
        intArrayOf(2, 3),
        intArrayOf(4, 0),
        intArrayOf(4, 5),
    )

    solution.minReorder(6, connections)
    solutionDFS.minReorder(6, connections)
}
