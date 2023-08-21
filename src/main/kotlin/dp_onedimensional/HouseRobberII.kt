package dp_onedimensional

class HouseRobberII {
    fun rob(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        if (nums.size == 1) return nums[0]
        return maxOf(helper(nums, 0, nums.size - 1), helper(nums, 1, nums.size))
    }

    private fun helper(nums: IntArray, start: Int, end: Int): Int {
        var pre2 = 0
        var pre1 = 0
        var curr = 0

        for (i in start..end) {
            curr = maxOf(pre1, pre2 + nums[i])
            pre2 = pre1
            pre1 = curr
        }

        return curr
    }
}

fun main() {
    val solution = HouseRobberII()
    solution.rob(intArrayOf(2, 3, 2))
}
