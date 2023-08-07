package `1ddp`

class MaximumSubarrayMinProduct {
    fun maxSumMinProduct(nums: IntArray): Int {
        val mod = 1000000007
        val stack = ArrayDeque<Pair<Int, Long>>() // Pair(lastIndexStart, value)
        val prefix = LongArray(nums.size + 1)

        for (i in nums.indices) {
            prefix[i + 1] = prefix[i] + nums[i]
        }

        var res = 0L
        for ((i, num) in nums.withIndex()) {
            var newStart = i

            while (stack.isNotEmpty() && stack.last().second > num) {
                val (lastIndexStart, value) = stack.removeLast()
                val total = prefix[i] - prefix[lastIndexStart]
                res = maxOf(res, total * value)
                newStart = lastIndexStart
            }

            stack.addLast(Pair(newStart, num.toLong()))
        }

        for ((start, value) in stack) {
            val total = prefix[nums.size] - prefix[start]
            res = maxOf(res, total * value)
        }

        return (res % mod).toInt()
    }
}

fun main() {
    val solution = MaximumSubarrayMinProduct()
    solution.maxSumMinProduct(intArrayOf(3, 1, 5, 6, 4, 2))
}
