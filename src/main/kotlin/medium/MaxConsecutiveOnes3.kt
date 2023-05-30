package medium

class MaxConsecutiveOnes3 {
    fun longestOnes(nums: IntArray, k: Int): Int {
        var ones = 0
        var max = 0
        var start = 0

        for (end in nums.indices) {
           if (nums[end] == 1) {
               ones++
           }

            if (end - start + 1 > ones + k) {
                if (nums[start] == 1) {
                    ones--
                }
                start++
            }

            max = max.coerceAtLeast(end - start + 1)
        }
        return max
    }
}

fun main() {
    val solution = MaxConsecutiveOnes3()
    println(solution.longestOnes(intArrayOf(1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0), 2))
    println(solution.longestOnes(intArrayOf(0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1), 3))
}
