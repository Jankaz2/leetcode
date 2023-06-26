package trees

import TreeNode

class ValidateBST {
    fun isValidBST(root: TreeNode?): Boolean {
        if (root == null) return true
        return valid(root, Int.MIN_VALUE, Int.MAX_VALUE)
    }

    private fun valid(root: TreeNode?, left: Int, right: Int): Boolean {
        if (root == null) return true
        if (!(root.`val` > left && root.`val` < right)) return false
        return valid(root.left, left, root.`val`) && valid(root.right, root.`val`, right)
    }
}
