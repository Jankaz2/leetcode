package graphs

class LargestColorValueInADirectedGraph {
    data class Node(val value: Int, val color: Char)

    fun largestPathValue(colors: String, edges: Array<IntArray>): Int {
        var max = Int.MIN_VALUE
        val adjacencyMap = mutableMapOf<Node, MutableList<Node>>()
        val visited = mutableSetOf<Int>()
        var result = mutableMapOf<Char, Int>()

        edges.forEach { (src, dst) ->
            if (src == dst) return -1
            adjacencyMap.getOrPut(Node(src, colors[src])) { mutableListOf() }.add(Node(dst, colors[dst]))
        }

        fun dfs(node: Node, parent: Int): Int {
            val (value, color) = node

            visited.add(value)

            if (value == parent) return -1
            if (color in result) result[color] = result[color]!! + 1 else result[color] = 1

            for ((neiNode, neiColor) in adjacencyMap[node] ?: mutableListOf()) {
                if (neiNode !in visited) {
                    dfs(Node(neiNode, neiColor), value).let { result = result.toMutableMap() }
                }
            }

            return result.values.max()
        }

        for (i in colors.indices) {
            if (i !in visited) {
                result = mutableMapOf()
                max = maxOf(max, dfs(Node(i, colors[i]), -1))
            }
        }

        return max
    }
}

fun main() {
    val solution = LargestColorValueInADirectedGraph()
    val colors = "hhqhuqhqff"
    val edges = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(0, 2),
        intArrayOf(2, 3),
        intArrayOf(3, 4),
        intArrayOf(3, 5),
        intArrayOf(5, 6),
        intArrayOf(2, 7),
        intArrayOf(6, 7),
        intArrayOf(7, 8),
        intArrayOf(3, 8),
        intArrayOf(5, 8),
        intArrayOf(8, 9),
        intArrayOf(3, 9),
        intArrayOf(6, 9)
    )

    println(solution.largestPathValue(colors, edges))
}
