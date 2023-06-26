package medium

import TreeNode
import toIntArray

class UniqueBinarySearchTree {
    private var counter = 0
    private var rootIndex = 1
    private var numsIndex = 1

    fun numTrees(n: Int): Int {
        val nums = (1..n).toIntArray()
        constructBinaryTree(nums)
        return counter
    }

    private fun constructBinaryTree(nums: IntArray): TreeNode? {
        if (nums.isEmpty() || rootIndex == nums.size) return null
        val root = TreeNode(rootIndex++)

        root.left = constructBinaryTree(nums.sliceArray(1 until nums.indexOf(root.`val`)))
        root.right = constructBinaryTree(nums.sliceArray(rootIndex + 1 until nums.size))

        numsIndex++
        counter++
        return root
    }
}

fun main() {
    val solution = UniqueBinarySearchTree()
    solution.numTrees(3)
}
