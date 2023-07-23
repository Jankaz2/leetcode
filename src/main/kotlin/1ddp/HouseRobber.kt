package `1ddp`

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
}

fun main() {
    val solution = HouseRobber()
    solution.rob(intArrayOf(2, 7, 9, 3, 1))
}
