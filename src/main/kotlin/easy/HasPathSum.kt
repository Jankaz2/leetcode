package easy

import TreeNode
import java.util.*

class HasPathSum {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) return false

        val stack = Stack<TreeNode>()
        stack.push(root)

        while (stack.isNotEmpty()) {
            val current = stack.pop()
            val sum = current.`val`

            if (current.left == null && current.right == null && sum == targetSum) {
                return true
            }

            current.right?.let {
                it.`val` = sum + it.`val`
                stack.push(it)
            }

            current.left?.let {
                it.`val` = sum + it.`val`
                stack.push(it)
            }
        }

        return false
    }

    fun hasPathSumRevursive(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) return false
        return hasPathSumRecursiveHelper(root, targetSum, 0)
    }

    private fun hasPathSumRecursiveHelper(node: TreeNode?, targetSum: Int, nodeSum: Int): Boolean =
        when {
            node == null -> false
            node.left == null && node.right == null && node.`val` + nodeSum == targetSum -> true
            else -> hasPathSumRecursiveHelper(node.left, targetSum, node.`val` + nodeSum)
                    || hasPathSumRecursiveHelper(node.right, targetSum, node.`val` + nodeSum)
        }

}

fun main() {
    val solution = HasPathSum()
    val root = TreeNode(5)
    root.left = TreeNode(4)
    root.left!!.left = TreeNode(11)
    root.left!!.left!!.left = TreeNode(7)
    root.left!!.left!!.right = TreeNode(2)


    root.right = TreeNode(8)
    root.right!!.left = TreeNode(13)
    root.right!!.right = TreeNode(4)
    root.right!!.right!!.right = TreeNode(1)

    solution.hasPathSum(root, 22)
}
