package dp_twodimensional

class OnesAndZeroes {
    fun findMaxFormDP(strs: Array<String>, m: Int, n: Int): Int {
        val cache = mutableMapOf<Triple<Int, Int, Int>, Int>() // index, m, n
        val M = m; val N = n;
        for (i in strs.indices) {
            val zeroes = strs[i].count { it == '0' }
            val ones = strs[i].length - zeroes

            for (m in 0 .. M) {
                for (n in 0 .. N) {
                    if (zeroes <= m && ones <= n) {
                        cache[Triple(i, m, n)] = maxOf(
                            1 + (cache[Triple(i - 1, m - zeroes, n - ones)] ?: 0),
                            cache[Triple(i - 1, m, n)] ?: 0
                        )
                    } else {
                        cache[Triple(i, m, n)] = cache[Triple(i - 1, m, n)] ?: 0
                    }
                }
            }
        }

        return cache[Triple(strs.lastIndex, m, n)]!!
    }

    fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {
        val cache = mutableMapOf<Triple<Int, Int, Int>, Int>() // index, m, n

        fun dfs(i: Int, m: Int, n: Int): Int {
            if (i >= strs.size) return 0
            if (Triple(i, m, n) in cache) return cache[Triple(i, m, n)]!!

            val zeroes = strs[i].count { it == '0' }
            val ones = strs[i].length - zeroes

            cache[Triple(i, m, n)] = dfs(i + 1, m, n)
            if (zeroes <= m && ones <= n) {
                val include = 1 + dfs(i + 1, m - zeroes, n - ones)
                cache[Triple(i, m, n)] = maxOf(cache[Triple(i, m, n)]!!, include)
            }

            return cache[Triple(i, m, n)]!!
        }

        return dfs(0, m, n)
    }
}
