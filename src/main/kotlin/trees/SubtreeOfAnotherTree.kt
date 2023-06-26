package trees

import TreeNode

class SubtreeOfAnotherTree {

    fun isSubtree2(root: TreeNode?, subRoot: TreeNode?): Boolean  {
        if (root == null) return false
        return isSame(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
    }

    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null && subRoot == null) return true
        if ((root == null && subRoot != null) || (root != null && subRoot == null))  return false

        val q = ArrayDeque<TreeNode>()
        q.add(root!!)

        while (q.isNotEmpty()) {
            for (i in 0 until q.size) {
                val node = q.removeFirst()
                if (node.`val` == subRoot?.`val` && isSame(node, subRoot)) {
                    return true
                }
                node.left?.let { q.add(it) }
                node.right?.let { q.add(it) }
            }
        }

        return false
    }

    private fun isSame(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == subRoot) return true
        if (root?.`val` != subRoot?.`val`) return false
        return isSame(root?.left, subRoot?.left) && isSame(root?.right, subRoot?.right)
    }
}

fun main() {
    val solution = SubtreeOfAnotherTree()
    val root = TreeNode(3)
    root.left = TreeNode(4)
    root.right = TreeNode(5)
    root.left!!.left = TreeNode(1)
    root.left!!.right = TreeNode(2)

    val subRoot = TreeNode(4)
    subRoot.left = TreeNode(1)
    subRoot.right = TreeNode(2)

    println(solution.isSubtree(root, subRoot))
    println(solution.isSubtree2(root, subRoot))
}
