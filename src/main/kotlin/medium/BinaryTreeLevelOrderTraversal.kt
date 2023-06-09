package medium

import TreeNode

class BinaryTreeLevelOrderTraversal {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        if (root == null) return result

        val q = ArrayDeque<TreeNode>()
        q.add(root)

        while (q.isNotEmpty()) {
            val level = mutableListOf<Int>()
            for (i in 0 until q.size) {
                val node = q.removeFirst()
                level.add(node.`val`)
                node.left?.let { q.add(it) }
                node.right?.let { q.add(it) }
            }
            result.add(level)
        }

        return result
    }

    fun levelOrderRecursive(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        if (root == null) return result

        return emptyList()
    }
}
