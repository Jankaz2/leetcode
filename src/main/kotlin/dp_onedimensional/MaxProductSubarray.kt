package dp_onedimensional

class MaxProductSubarray {
    fun maxProduct(nums: IntArray): Int {
        var res = nums[0]
        var curMin = 1
        var curMax = 1

        for (num in nums) {
            val candidates = listOf(
                num,
                num * curMax,
                num * curMin
            )

            curMax = candidates.max()
            curMin = candidates.min()
            res = maxOf(res, curMax)
        }

        return res
    }
}

fun main() {
    val solution = MaxProductSubarray()
    solution.maxProduct(intArrayOf(2, 3, 2, 0, -3, -6, 4))
}
