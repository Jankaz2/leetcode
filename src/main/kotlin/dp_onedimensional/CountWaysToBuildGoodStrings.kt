package dp_onedimensional

class CountWaysToBuildGoodStrings {
    private val mod = 1000000007

    fun countGoodStrings(low: Int, high: Int, zero: Int, one: Int): Int {
        val cache = mutableMapOf<Int, Int>()

        cache[0] = 1
        for (length in 1..high + 1) {

            cache[length] = (
                    cache.getOrDefault(length, 0) +
                            cache.getOrDefault(length - zero, 0) +
                            cache.getOrDefault(length - one, 0)
                    ) % mod
        }

        var sum = 0
        for (i in low..high) sum = (sum + cache[i]!!) % mod
        return sum
    }

    fun countGoodStringsRecursive(low: Int, high: Int, zero: Int, one: Int): Int {
        val mod = 1000000007
        val cache = mutableMapOf<Int, Int>()

        fun dfs(length: Int): Int {
            if (length > high) return 0
            if (length in cache) return cache[length]!!

            cache[length] = if (length >= low) 1 else 0
            cache[length] = cache[length]!! + dfs(length + zero) + dfs(length + one)
            cache[length] = cache[length]!! % mod

            return cache[length]!!
        }

        return dfs(0)
    }
}
