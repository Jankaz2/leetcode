package easy

import TreeNode
import printTreeNodes

class InvertBinaryTree {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null
        val temp = root.left
        root.left = root.right
        root.right = temp

        invertTree(root.left)
        invertTree(root.right)
        return root
    }
}

fun main() {
    val solution = InvertBinaryTree()
    val root = TreeNode(4)
    root.left = TreeNode(2)
    root.right = TreeNode(7)
    root.left!!.left = TreeNode(1)
    root.left!!.right = TreeNode(3)
    root.right!!.left = TreeNode(6)
    root.right!!.right = TreeNode(9)
    printTreeNodes(root)
    solution.invertTree(root)
    printTreeNodes(root)
}
