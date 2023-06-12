package medium

import TreeNode

class PathSumII {
    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        if (root == null) return emptyList()
        val paths = mutableListOf<MutableList<Int>>()
        dfs(root, targetSum, ArrayList(), paths)
        return paths
    }

    private fun dfs(root: TreeNode?, sum: Int, current: MutableList<Int>, paths: MutableList<MutableList<Int>>) {
        if (root == null) return

        current.add(root.`val`)
        if (root.`val` == sum && root.left == null && root.right == null) {
            paths.add(ArrayList(current))
        }

        dfs(root.left, sum - root.`val` , current, paths)
        dfs(root.right, sum - root.`val`, current, paths)

        current.removeLast()
    }
}

fun main() {
    val solution = PathSumII()
    val root = TreeNode(5)
    root.left = TreeNode(4)
    root.left!!.left = TreeNode(11)
    root.left!!.left!!.left = TreeNode(7)
    root.left!!.left!!.right = TreeNode(2)

    root.right = TreeNode(8)
    root.right!!.left = TreeNode(13)
    root.right!!.right = TreeNode(4)
    root.right!!.right!!.left = TreeNode(5)
    root.right!!.right!!.right = TreeNode(1)

    solution.pathSum(root, 22)
}

