package easy

import TreeNode
import printTreeNodes

class ConvertSortedArrayToBST {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        if (nums.isEmpty()) return null
        val root = TreeNode(nums[nums.size / 2])
        val mid = nums.indexOf(root.`val`)
        root.left = sortedArrayToBST(nums.sliceArray(0 until mid))
        root.right = sortedArrayToBST(nums.sliceArray(mid + 1 until nums.size))
        return root
    }

}

fun main() {
    val solution = ConvertSortedArrayToBST()
    val r = solution.sortedArrayToBST(intArrayOf(0, 1, 2, 3, 4, 5))
    printTreeNodes(r)
}
