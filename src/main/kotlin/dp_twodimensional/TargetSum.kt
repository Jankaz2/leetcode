package dp_twodimensional

class TargetSum {
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        val cache = mutableMapOf<Pair<Int, Int>, Int>()

        fun dfs(i: Int, current: Int): Int {
            if (i == nums.size) return if (current == target) 1 else 0
            if (Pair(i, current) in cache) return cache[Pair(i, current)]!!

            val plus = dfs(i + 1, current + nums[i])
            val minus = dfs(i + 1, current - nums[i])
            cache[Pair(i, current)] = plus + minus

            return cache[Pair(i, current)]!!
        }

        return dfs(0, 0)
    }
}

fun main() {
    val solution = TargetSum()
    solution.findTargetSumWays(intArrayOf(1, 1, 1, 1, 1), 3)
}
