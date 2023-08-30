package dp_twodimensional

class MaximumAlternatingSubsequenceSum {
    fun maxAlternatingSumDp(nums: IntArray): Long {
        var sumEven = 0L
        var sumOdd = 0L

        for (i in nums.lastIndex downTo 0) {
            val tmpEven = maxOf(sumOdd + nums[i], sumEven)
            val tmpOdd = maxOf(sumEven - nums[i], sumOdd)
            sumEven = tmpEven
            sumOdd = tmpOdd
        }

        return sumEven
    }
    fun maxAlternatingSum(nums: IntArray): Long {
        val cache = mutableMapOf<Pair<Int, Char>, Long>()
        fun dfs(i: Int, sign: Char): Long {
            if (i >= nums.size) return 0
            if (Pair(i, sign) in cache) return cache[Pair(i, sign)]!!

            if (sign == '-') {
                val include = nums[i] * (-1) + dfs(i + 1, '+')
                val notInclude = dfs(i + 1, '-')
                cache[Pair(i, sign)] = maxOf(
                    cache[Pair(i, sign)] ?: 0,
                    include,
                    notInclude
                )
            } else {
                val include = nums[i] + dfs(i + 1, '-')
                val notInclude = dfs(i + 1, '+')
                cache[Pair(i, sign)] = maxOf(
                    cache[Pair(i, sign)] ?: 0,
                    include,
                    notInclude
                )
            }

            return cache[Pair(i, sign)]!!
        }

        return dfs(0, '+')
    }
}

fun main() {
    val solution = MaximumAlternatingSubsequenceSum()
    solution.maxAlternatingSum(intArrayOf(4, 2, 5, 3))
}
