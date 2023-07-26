package `1ddp`

class LongestIncreasingSubsequence {
    fun lengthOfLIS(nums: IntArray): Int {
        if (nums.size == 1) return 1
        val dp = Array(nums.size) { 1 }
        for (i in nums.size - 1 downTo 0) {
            for (j in i + 1 until nums.size) {
                if (nums[i] < nums[j]) {
                    dp[i] = maxOf(dp[i], dp[j] + 1)
                }
            }
        }
        return dp.max()!!
    }
}

fun main() {
    val solution = LongestIncreasingSubsequence()
    val res = solution.lengthOfLIS(intArrayOf(1, 2, 4, 3))
    println(res)
}
