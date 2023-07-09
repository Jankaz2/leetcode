package graphs

class EvaluateDivision {
    fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
        val result = DoubleArray(queries.size) { -1.0 }
        val adjMap = mutableMapOf<String, MutableList<Pair<String, Double>>>()

        equations.forEachIndexed { i, (n1, n2) ->
            adjMap.getOrPut(n1) { mutableListOf() }.add(Pair(n2, values[i]))
            adjMap.getOrPut(n2) { mutableListOf() }.add(Pair(n1, (1 / values[i])))
        }

        fun bfs(q1: String, q2: String): Double {
            val que = ArrayDeque<Pair<String, Double>>()
            val visited = mutableSetOf<String>()

            que.add(Pair(q1, 1.0))

            while (que.isNotEmpty()) {
                val (current, res) = que.removeFirst()

                for ((nei, value) in adjMap[current]!!) {
                    if (nei in visited) continue
                    if (nei == q2) return value * res
                    que.add(Pair(nei, value * res))
                    visited.add(nei)
                }
            }

            return -1.0
        }

        queries.forEachIndexed { i, (q1, q2) ->
            if (q1 in adjMap && q2 in adjMap) {
                result[i] = bfs(q1, q2)
            }
        }

        return result
    }
}

fun main() {
    val solution = EvaluateDivision()
    val equations = listOf(
        listOf("a", "b"),
        listOf("b", "c")
    )

    val queries = listOf(
        listOf("a", "c"),
        listOf("b", "a"),
        listOf("a", "e"),
        listOf("a", "a"),
        listOf("x", "x"),
    )

    solution.calcEquation(equations, doubleArrayOf(2.0, 3.0), queries)
}
