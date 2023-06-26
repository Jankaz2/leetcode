package graphs

class NumberOfConnectedComponentsInAnUndirectedGraph {

    fun countComponents(n:Int, edges:Array<IntArray>): Int {
        val parents = ArrayList<Int>()
        val ranks = ArrayList<Int>()
        var counter = n

        for (i in 0 until n) {
            parents.add(i)
            ranks.add(i)
        }

        fun find(n: Int): Int {
            var parent = n
            while (parent != parents[parent]) {
                parents[parent] = parents[parents[parent]]
                parent = parents[parent]
            }

            return parent
        }

        fun union(n1: Int, n2: Int): Int {
            val p1 = find(n1)
            val p2 = find(n2)

            if (p1 == p2) return 0

            if (ranks[p1] > ranks[p2]) {
                ranks[p2] = p1
                ranks[p1] += ranks[p2]
            } else {
                ranks[p1] = p2
                ranks[p2] += ranks[p1]
            }

            return 1
        }

        for ((n1, n2) in edges) {
            counter -= union(n1, n2)
        }

        return counter
    }
}

fun main() {
    val solution = NumberOfConnectedComponentsInAnUndirectedGraph()
    val edges = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 2),
        intArrayOf(3, 4),
    )

    println(solution.countComponents(5, edges))

}
