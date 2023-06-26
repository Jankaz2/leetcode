package graphs

class RedundantConnection {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val parent = IntArray(edges.size + 1) { it }
        val rank = IntArray(edges.size + 1) { 1 }

        fun find(n: Int): Int {
            var p = parent[n]
            while (p != parent[p]) {
                parent[p] = parent[parent[p]]
                p = parent[p]
            }

            return p
        }

        fun union(n1: Int, n2: Int): Boolean {
            val parent1 = find(n1)
            val parent2 = find(n2)

            if (parent1 == parent2) return false

            if (rank[parent1] > rank[parent2]) {
                parent[parent2] = parent1
                rank[parent1] += rank[parent2]
            } else {
                parent[parent1] = parent2
                rank[parent2] += rank[parent1]
            }

            return true
        }

        for ((n1, n2) in edges) {
            if (!union(n1, n2)) return intArrayOf(n1, n2)
        }

        return intArrayOf()
    }
}

fun main() {
    val solution = RedundantConnection()
    val edges = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(2, 3),
        intArrayOf(3, 4),
        intArrayOf(1, 5),
        intArrayOf(5, 6),
        intArrayOf(6, 7),
        intArrayOf(7, 8),
        intArrayOf(8, 3),
    )
    solution.findRedundantConnection(edges)
}
