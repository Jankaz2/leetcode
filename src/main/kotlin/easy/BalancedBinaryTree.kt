package easy

import TreeNode
import kotlin.math.abs

class BalancedBinaryTree {

    fun isBalanced(root: TreeNode?): Boolean {
       return dfs(root) != Int.MAX_VALUE
    }

    private fun dfs(root: TreeNode?): Int {
        if (root == null) return 0

        val leftDepth = dfs(root.left)
        val rightDepth = dfs(root.right)

        if (leftDepth == Int.MAX_VALUE || rightDepth == Int.MAX_VALUE) {
            return Int.MAX_VALUE
        }

        if (abs(leftDepth - rightDepth) > 1) {
            return Int.MAX_VALUE
        }

        return maxOf(leftDepth, rightDepth) + 1
    }
}

fun main() {
    val solution = BalancedBinaryTree()
    val root1 = TreeNode(3)
    root1.left = TreeNode(9)
    root1.right = TreeNode(20)
    root1.right!!.left = TreeNode(15)
    root1.right!!.right = TreeNode(7)
    println(solution.isBalanced(root1))

    val root2 = TreeNode(1)
    root2.left = TreeNode(2)
    root2.right = TreeNode(2)
    root2.left!!.left = TreeNode(3)
    root2.left!!.right = TreeNode(3)
    root2.left!!.left!!.left = TreeNode(4)
    root2.left!!.left!!.right = TreeNode(4)
    println(solution.isBalanced(root2))

    val root3 = null
    println(solution.isBalanced(root3))

    val root4 = TreeNode(1)
    root4.left = TreeNode(2)
    root4.right = TreeNode(3)
    root4.left!!.left = TreeNode(4)
    root4.left!!.right = TreeNode(5)
    root4.left!!.right!!.left = TreeNode(6)
    println(solution.isBalanced(root4))
}
