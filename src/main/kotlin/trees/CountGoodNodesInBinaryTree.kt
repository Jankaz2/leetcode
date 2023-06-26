package trees

import TreeNode

class CountGoodNodesInBinaryTree {
    var result = 0

    fun goodNodes(root: TreeNode?): Int {
        if (root == null) return 0
        dfs(root, Int.MIN_VALUE)
        return result
    }

    private fun dfs(root: TreeNode?, max: Int)  {
        if (root == null) return
        if (root.`val` >= max) {
            result++
        }

        dfs(root.left, root.`val`.coerceAtLeast(max))
        dfs(root.right, root.`val`.coerceAtLeast(max))
    }
}
