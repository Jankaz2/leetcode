package arrays_and_hashing

class TwoSum {
    fun twoSum(nums: IntArray = intArrayOf(2, 5, 5, 11), target: Int): IntArray {
        val numToIndex: MutableMap<Int, Int> = mutableMapOf()
        for (i in nums.indices) {
            if (numToIndex.containsKey(target - nums[i])) {
                return intArrayOf(numToIndex[target - nums[i]]!!, i)
            }
            numToIndex[nums[i]] = i
        }

        return intArrayOf()
    }
}

fun main() {
    val twoSum = TwoSum()
    twoSum.twoSum(intArrayOf(2, 5, 5, 11), 10).forEach { println(it) }
}
