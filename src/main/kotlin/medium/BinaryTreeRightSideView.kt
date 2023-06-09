package medium

import TreeNode
import kotlin.collections.ArrayDeque

class BinaryTreeRightSideView {
    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()

        val q = ArrayDeque<TreeNode>()
        val result = mutableListOf<Int>()

        q.add(root)
        result.add(root.`val`)

        while (q.isNotEmpty()) {
            for (i in 0 until q.size) {
                val node = q.removeFirst()
                node.left?.let { q.add(it) }
                node.right?.let { q.add(it) }
            }
            if (q.size > 0) {
                val valueToAdd = q.last().`val`
                result.add(valueToAdd)
            }
        }

        return result
    }


}

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> =
        root?.let { node ->
            listOf(node.`val`) + rightSideView(node.right)
            .let { it + rightSideView(root.left).drop(it.size) } }
            ?: emptyList()
}

fun main() {
    val solution = BinaryTreeRightSideView()
    val root = TreeNode(1)
    root.left = TreeNode(2)
//    root.right = TreeNode(3)
//    root.left!!.right = TreeNode(5)
//    root.right!!.right = TreeNode(4)
    solution.rightSideView(root)
}

