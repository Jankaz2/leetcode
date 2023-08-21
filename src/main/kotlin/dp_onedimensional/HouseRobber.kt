package dp_onedimensional

import kotlin.math.max

class HouseRobber {
    fun rob(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        var prev1 = 0
        var prev2 = 0

        for (num in nums) {
            val tmp = prev1
            prev1 = maxOf(prev2 + num, prev1)
            prev2 = tmp
        }

        return prev1
    }

    fun rob2(nums: IntArray): Int {
        if (nums.size < 2) return nums[0]

        val dp = IntArray(nums.size)

        dp[0] = nums[0]
        dp[1] = max(nums[0].toDouble(), nums[1].toDouble()).toInt()

        for (i in 2 until nums.size) {
            dp[i] = max((dp[i - 2] + nums[i]).toDouble(), dp[i - 1].toDouble()).toInt()
        }
        return dp[nums.size - 1]
    }

}

fun main() {
    val solution = HouseRobber()
    solution.rob(intArrayOf(2, 7, 9, 3, 1))
}
