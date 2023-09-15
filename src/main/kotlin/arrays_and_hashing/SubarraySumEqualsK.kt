package arrays_and_hashing

class SubarraySumEqualsK {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val prefixes = mutableMapOf<Int, Int>()
        var currSum = 0
        var res = 0
        prefixes[0] = 1

        for (n in nums) {
            currSum += n
            val diff = currSum - k
            res += prefixes.getOrDefault(diff, 0)
            prefixes[currSum] = 1 + prefixes.getOrDefault(currSum, 0)
        }

        return res
    }
}

fun main() {
    val solution = SubarraySumEqualsK()
    solution.subarraySum(intArrayOf(1, 2, 3), 3)
}
