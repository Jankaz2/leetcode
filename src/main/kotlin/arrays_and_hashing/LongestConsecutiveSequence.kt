package arrays_and_hashing

import kotlin.math.max

class LongestConsecutiveSequence {
    fun longestConsecutive(nums: IntArray): Int {
        var longest = 0
        val set = setOf(*nums.toTypedArray())
        for (num in nums) {
            if (!set.contains(num - 1)) {
                var currentSequenceLength = 0
                while ((num + currentSequenceLength) in set) {
                    currentSequenceLength++
                }
                longest = max(longest, currentSequenceLength)
            }
        }
        return longest
    }
}

fun main() {
    val solution = LongestConsecutiveSequence()
    val nums = intArrayOf(100, 4, 200, 1, 3, 2)
    val nums2 = intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)
    println(solution.longestConsecutive(nums))
}
