package trees

import TreeNode
import java.util.*

class KthSmallestElementInABST {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        if (root == null) return 0
        val stack = Stack<TreeNode>()
        var current = root
        var n = 0
        while (true) {
            while (current != null) {
                stack.push(current)
                current = current.left
            }
            val temp = stack.pop()
            if (++n == k) return temp.`val`
            current = temp.right
        }
    }
}

fun main() {
    val solution = KthSmallestElementInABST()
    val root = TreeNode(5)
    root.left = TreeNode(3)
    root.right = TreeNode(6)
    root.left!!.left = TreeNode(2)
    root.left!!.right = TreeNode(4)
    root.left!!.left!!.left = TreeNode(1)
    solution.kthSmallest(root, 3)
}
