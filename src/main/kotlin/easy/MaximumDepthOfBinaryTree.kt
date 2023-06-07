package easy

import TreeNode
import java.util.Stack

class MaximumDepthOfBinaryTree {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val leftDepth = maxDepth(root.left)
        val rightDepth = maxDepth(root.right)
        return 1 + maxOf(leftDepth, rightDepth)
    }

    fun bfs(root: TreeNode?): Int {
        if (root == null) return 0

        var level = 0
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            for (i in 0 until queue.size) {
                val node = queue.removeLast()
                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
            }
            level++
        }

        return level
    }

    fun ifs(root: TreeNode?): Int {
        var max = 0
        val stack = Stack<Pair<TreeNode?, Int>>()
        stack.push(Pair(root, 1))
        while (stack.isNotEmpty()) {
            val (node, depth) = stack.pop()
            node?.let {
                max = max.coerceAtLeast(depth)
                stack.add(Pair(it.left, depth + 1))
                stack.add(Pair(it.right, depth + 1))
            }

        }

        return max
    }

}

fun main() {
    val solution = MaximumDepthOfBinaryTree()
    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right!!.left = TreeNode(15)
    root.right!!.right = TreeNode(7)
    println(solution.maxDepth(root))
    println(solution.bfs(root))
    println(solution.ifs(root))
}
