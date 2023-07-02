package graphs


class FindEventualSafeStates {

    internal enum class State {
        SAFE,
        UNSAFE
    }

    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
        val safeNodes: MutableList<Int> = ArrayList(graph.size)
        val states = arrayOfNulls<State>(graph.size)

        fun isSafe(node: Int, states: Array<State?>): Boolean {
            states[node]?.let {
                return it == State.SAFE
            }

            states[node] = State.UNSAFE
            for (neighbor in graph[node]) {
                if (!isSafe(neighbor, states)) {
                    return false
                }
            }
            states[node] = State.SAFE
            return true
        }

        for (node in graph.indices) {
            if (isSafe(node, states)) {
                safeNodes.add(node)
            }
        }

        return safeNodes
    }

}

fun main() {
    val graph = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(2, 3),
        intArrayOf(5),
        intArrayOf(0),
        intArrayOf(5),
        intArrayOf(),
        intArrayOf(),
    )

    val solution = FindEventualSafeStates()
    solution.eventualSafeNodes(graph)
}
