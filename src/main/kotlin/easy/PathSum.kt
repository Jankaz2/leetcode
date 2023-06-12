package easy

import TreeNode
import java.util.*

class PathSum {
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
        return when {
            root == null -> false
            root.left == null && root.right == null -> targetSum - root.`val` == 0
            else -> hasPathSumRevursive(root.left, targetSum - root.`val`)
                    || hasPathSumRevursive(root.right, targetSum - root.`val`)
        }
    }
}

fun main() {
    val solution = PathSum()
    val root = TreeNode(5)
    root.left = TreeNode(4)
    root.left!!.left = TreeNode(11)
    root.left!!.left!!.left = TreeNode(7)
    root.left!!.left!!.right = TreeNode(2)


    root.right = TreeNode(8)
    root.right!!.left = TreeNode(13)
    root.right!!.right = TreeNode(4)
    root.right!!.right!!.right = TreeNode(1)

    solution.hasPathSumRevursive(root, 22)
}
