package graphs

class GraphValidTree {

    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        val visited = HashSet<IntArray>()
        val ranks = IntArray(n) { 1 }
        val parents = IntArray(n) { it }

        fun find(n: Int): Int {
            var result = n
            while (result != parents[result]) {
                parents[result] = parents[parents[result]]
                result = parents[result]
            }
            return result
        }

        fun union(n1: Int, n2: Int): Boolean {
            val p1 = find(n1)
            val p2 = find(n2)

            if (p1 == p2) {
                return false
            }

            if (ranks[p1] > ranks[p2]) {
                parents[p2] = p1
                ranks[p1] += ranks[p2]
            } else {
                parents[p1] = p2
                ranks[p2] += ranks[p1]
            }

            return true
        }

        for ((n1, n2) in edges) {
            if (visited.contains(intArrayOf(n1, n2)) || visited.contains(intArrayOf(n2, n1)) || !union(n1, n2)) {
                return false
            }
            visited.add(intArrayOf(n1, n2))
        }

        return edges.size == n - 1
    }

    fun validTreeDFS(n: Int, edges: Array<IntArray>): Boolean {
        val visited = mutableSetOf<Int>()
        val adjacencyMap = mutableMapOf<Int, MutableList<Int>>()
        for (i in 0 until n) {
            adjacencyMap[i] = mutableListOf()
        }

        for ((i, j) in edges) {
            adjacencyMap[i]!!.add(j)
            adjacencyMap[j]!!.add(i)
        }

        fun dfs(node: Int, prev: Int): Boolean {
            if (node in visited) return false

            visited.add(node)
            for (adjacent in adjacencyMap[node]!!) {
                if (adjacent == prev) continue
                if (!dfs(adjacent, node)) return false
            }

            return true
        }

        return dfs(0, -1) && visited.size == n
    }

}

fun main() {
    val solution = GraphValidTree()
    val edges = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 2),
        intArrayOf(2, 3),
        intArrayOf(1, 3),
        intArrayOf(1, 4),
    )

    println(solution.validTree(5, edges))
}
