package trees

import TreeNode

class BinaryTreeInorderTraversal {

    private val result = mutableListOf<Int>()

    fun inorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        traverse(root)
        return result
    }

    private fun traverse(root: TreeNode?) {
        if (root == null) return
        traverse(root.left)
        result.add(root.`val`)
        traverse(root.right)
    }
}
