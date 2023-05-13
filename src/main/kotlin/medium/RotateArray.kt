package medium

class RotateArray {
    fun rotate(nums: IntArray, k: Int) {
        val keepingNums = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            keepingNums[(i + k) % nums.size] = nums[i]
        }

        for (j in nums.indices) {
            nums[j] = keepingNums[j]!!
        }
    }
}

