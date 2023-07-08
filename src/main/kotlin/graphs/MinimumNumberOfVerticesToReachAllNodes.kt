package graphs

class MinimumNumberOfVerticesToReachAllNodes {
    fun findSmallestSetOfVertices(n: Int, edges: List<List<Int>>): List<Int> {
        val seen = BooleanArray(n - 1) { false }
        for ((_, to) in edges) {
            seen[to] = true
        }

        val result = mutableListOf<Int>()
        for ((i, s) in seen.withIndex()) {
            if (s) {
                result.add(i)
            }
        }

        return result
    }
}
