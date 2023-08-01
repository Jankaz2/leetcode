package `1ddp`

class NumberOfLongestIncreasingSubsequence {
    fun findNumberOfLIS(nums: IntArray): Int {
        val dp = mutableMapOf<Int, Pair<Int, Int>>() // the pair is (length of LIS, counter)
        var globalMaxLen = 0
        var globalMaxCount = 0

        for (i in nums.size - 1 downTo 0) {
            var currentMaxLen = 1
            var currentMaxCount = 1

            for (j in i + 1 until nums.size) {
                if (nums[j] > nums[i]) {
                    val (lisLength, counter) = dp[j]!!
                    if (lisLength + 1 > currentMaxLen) {
                        currentMaxLen = lisLength + 1
                        currentMaxCount = counter
                    } else if (lisLength + 1 == currentMaxLen) {
                        currentMaxCount += counter
                    }
                }
            }

            if (currentMaxLen > globalMaxLen) {
                globalMaxLen = currentMaxLen
                globalMaxCount = currentMaxCount
            } else if (currentMaxLen == globalMaxLen) {
                globalMaxCount += currentMaxCount
            }

            dp[i] = Pair(currentMaxLen, currentMaxCount)
        }

        return globalMaxCount
    }
}
