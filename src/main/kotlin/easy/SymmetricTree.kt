package easy

import TreeNode


class SymmetricTree {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return true
        return dfs(root.left, root.right)
    }

    private fun dfs(left: TreeNode?, right: TreeNode?): Boolean = when {
        left?.`val` == null && right?.`val` == null -> true
        left?.`val` == null || right?.`val` == null -> false
        left.`val` == right.`val`
                && dfs(left.left, right.right)
                && dfs(left.right, right.left) -> true
        else -> false
    }
}

fun main() {
    val solution = SymmetricTree()
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(2)
    root.left!!.right = TreeNode(3)
    root.right!!.right = TreeNode(3)
    solution.isSymmetric(root)
}
