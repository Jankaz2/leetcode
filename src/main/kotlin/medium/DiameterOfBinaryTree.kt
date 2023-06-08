package medium

import TreeNode

class DiameterOfBinaryTree {

    private var max = 0

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        dfs(root)
        return max
    }

    private fun dfs(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        val leftDepth = dfs(root.left)
        val rightDepth = dfs(root.right)
        max = maxOf(max, leftDepth + rightDepth)

        return 1 + maxOf(leftDepth, rightDepth)
    }

}

fun main() {
    val solution = DiameterOfBinaryTree()
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left!!.left = TreeNode(4)
    root.left!!.right = TreeNode(5)
    println(solution.diameterOfBinaryTree(root))
}
