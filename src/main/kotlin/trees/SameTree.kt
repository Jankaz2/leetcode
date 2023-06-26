package trees

import TreeNode

enum class Direction {
    LEFT,
    RIGHT
}

class SameTree {
    fun isSameTreeRecursive(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == q) return true
        if (p?.`val` != q?.`val`) return false
        return isSameTreeIterative(p?.left, q?.left) && isSameTreeIterative(p?.right, q?.right)
    }

    fun isSameTreeIterative(p: TreeNode?, q: TreeNode?): Boolean {
        if ((p == null && q != null) || (p != null && q == null)) return false
        if (p == null && q == null) return true

        val pq = ArrayDeque<Pair<TreeNode, Direction>>()
        val qq = ArrayDeque<Pair<TreeNode, Direction>>()
        pq.add(Pair(p!!, Direction.LEFT))
        qq.add(Pair(q!!, Direction.LEFT))

        while (pq.isNotEmpty() && qq.isNotEmpty()) {
            for (i in 0 until pq.size) {
                val pNode = pq.removeFirst()
                val qNode = qq.removeFirst()
                if (compareTreeNodes(pNode, qNode)) {
                    return false
                }
                pNode.first.left?.let { pq.add(Pair(it, Direction.LEFT)) }
                pNode.first.right?.let { pq.add(Pair(it, Direction.RIGHT)) }
                qNode.first.left?.let { qq.add(Pair(it, Direction.LEFT)) }
                qNode.first.right?.let { qq.add(Pair(it, Direction.RIGHT)) }
            }
        }

        return pq.size == qq.size
    }

    private fun compareTreeNodes(p: Pair<TreeNode, Direction>, q: Pair<TreeNode, Direction>): Boolean {
        return (p.second != q.second) || (p.first.`val` != q.first.`val`) || (p.first.left?.`val` != q.first.left?.`val`) || (p.first.right?.`val` != q.first.right?.`val`)
    }

}

fun main() {
    val solution = SameTree()
    val root1 = TreeNode(1)
    root1.left = TreeNode(2)
    root1.right = TreeNode(3)

    val root2 = TreeNode(1)
    root2.left = TreeNode(2)
    root2.right = TreeNode(3)
    println(root1 == root2)

    println(solution.isSameTreeIterative(root1, root2))

    val root3 = TreeNode(1)
    root3.left = TreeNode(2)

    val root4 = TreeNode(1)
    root4.right = TreeNode(2)

    println(solution.isSameTreeIterative(root3, root4))

    val root5 = TreeNode(1)
    root5.right = TreeNode(2)
    root5.right!!.left = TreeNode(3)

    val root6 = TreeNode(1)
    root6.right = TreeNode(2)
    root6.right!!.right = TreeNode(3)

    println(solution.isSameTreeIterative(root5, root6))
}
