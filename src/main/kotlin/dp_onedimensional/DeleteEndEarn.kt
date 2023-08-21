package dp_onedimensional

class DeleteEndEarn {
    data class ValueCount(val value: Int, var count: Int)

    fun deleteAndEarn(nums: IntArray): Int {
        val max = nums.max()
        val store = IntArray(max + 1) { 0 }

        for (num in nums) {
            store[num] += num
        }

        val dp = IntArray(store.size)
        dp[1] = 1 * store[1]

        for (i in 2 until dp.size) {
            dp[i] = maxOf(dp[i - 2] + store[i], dp[i - 1])
        }

        return dp[dp.lastIndex]
    }
}

fun main() {
    val solution = DeleteEndEarn()
    solution.deleteAndEarn(intArrayOf(3, 4, 2))
    solution.deleteAndEarn(intArrayOf(2, 2, 3, 3, 3, 4, 4))
}
