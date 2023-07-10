package graphs

import kotlin.math.ceil

class MinimumFuelCostToReportToTheCapital {
    fun minimumFuelCost(roads: Array<IntArray>, seats: Int): Long {
        val adjacencyMap = mutableMapOf<Int, MutableList<Int>>()
        var fuel = 0L

        roads.forEach { (src, dst) ->
            adjacencyMap.getOrPut(src) { mutableListOf() }.add(dst)
            adjacencyMap.getOrPut(dst) { mutableListOf() }.add(src)
        }

        fun dfs(node: Int, parent: Int): Long {
            var passengers = 0L

            for (child in adjacencyMap[node] ?: mutableListOf()) {
                if (child != parent) {
                    val p = dfs(child, node)
                    passengers += p
                    fuel += ceil((p.toDouble() / seats)).toLong()
                }
            }

            return passengers + 1
        }

        dfs(0, -1)
        return fuel
    }
}
