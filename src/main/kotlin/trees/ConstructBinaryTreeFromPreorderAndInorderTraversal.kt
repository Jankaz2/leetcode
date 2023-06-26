package trees

import TreeNode

class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        if (preorder.isEmpty() || inorder.isEmpty()) return null
        val root = TreeNode(preorder[0])
        val mid = inorder.indexOf(preorder[0])

        // left subtree
        root.left = buildTree(
            preorder.slice(1..mid).toIntArray(),
            inorder.slice(0 until mid).toIntArray()
        )

        // right subtree
        root.right = buildTree(
            preorder.slice(mid + 1 until preorder.size).toIntArray(),
            inorder.slice(mid + 1 until inorder.size).toIntArray()
        )

        return root
    }
}
