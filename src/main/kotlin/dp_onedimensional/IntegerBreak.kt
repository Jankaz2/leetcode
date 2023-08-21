package dp_onedimensional

class IntegerBreak {

    fun integerBreak(n: Int): Int {
        val cache = mutableMapOf(1 to 1)

        for (num in 2..n) {
            cache[num] = if (num == n) 0 else num
            for (i in 1 until num) {
                val product = cache[i]!! * cache[num - i]!!
                cache[num] = maxOf(cache[num]!!, product)
            }
        }

        return cache[n]!!
    }

    fun integerBreakRecurse(n: Int): Int {
        val cache = mutableMapOf(1 to 1)

        fun dfs(breakingNum: Int): Int {
            if (breakingNum in cache) {
                return cache[breakingNum]!!
            }

            cache[breakingNum] = if (breakingNum == n) 0 else breakingNum
            for (num in 1 until breakingNum) {
                val product = dfs(num) * dfs(breakingNum - num)
                cache[breakingNum] = maxOf(cache[breakingNum]!!, product)
            }

            return cache[breakingNum]!!
        }

        return dfs(n)
    }
}
