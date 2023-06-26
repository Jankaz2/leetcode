package graphs

import Node
import java.util.Stack

class CloneGraph {
    fun cloneGraph(node: Node?): Node? {
        val oldToNew = hashMapOf<Int, Node>()

        fun clone(node: Node?): Node? {
            if (node == null) return null
            if (node.`val` in oldToNew) return oldToNew[node.`val`]

            val copy = Node(node.`val`)
            oldToNew[node.`val`] = copy
            for (neighbor in node.neighbors) {
                copy.neighbors.add(clone(neighbor))
            }

            return copy
        }

        return if (node != null) clone(node) else null
    }

    fun cloneGraphBFS(node: Node?): Node? {
        if (node == null) return null

        val oldToNew = mutableMapOf<Node, Node>()
        val q = ArrayDeque<Node>()
        q.add(node)
        oldToNew[node] = Node(node.`val`)

        while (q.isNotEmpty()) {
            val current = q.removeFirst()
            for (n in current.neighbors) {
                if (n !in oldToNew) {
                    val copy = Node(n!!.`val`)
                    oldToNew[n] = copy
                    q.add(n)
                }
                oldToNew[current]!!.neighbors.add(oldToNew[n])
            }
        }

        return oldToNew[node]
    }

    fun cloneGraphDFS(node: Node?): Node? {
        if (node == null) return null

        val oldToNew = mutableMapOf<Node, Node>()
        val q = Stack<Node>()
        q.add(node)
        oldToNew[node] = Node(node.`val`)

        while (q.isNotEmpty()) {
            val current = q.pop()
            for (n in current.neighbors) {
                if (n !in oldToNew) {
                    val copy = Node(n!!.`val`)
                    oldToNew[n] = copy
                    q.add(n)
                }
                oldToNew[current]!!.neighbors.add(oldToNew[n])
            }
        }

        return oldToNew[node]
    }

}
