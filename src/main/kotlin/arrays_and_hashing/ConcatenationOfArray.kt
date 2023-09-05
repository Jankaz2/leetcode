package arrays_and_hashing

class ConcatenationOfArray {
    fun getConcatenation(nums: IntArray): IntArray {
        val result = IntArray(nums.size * 2)
        for (i in nums.indices) {
            result[i] = nums[i]
            result[nums.size + i] = nums[i]
        }

        return result
    }
}
