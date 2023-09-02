package dp_twodimensional

class DistinctSubsequences {
    fun numDistinct(s: String, t: String): Int {
        val cache = mutableMapOf<Pair<Int, Int>, Int>()

        fun dfs(i: Int, j: Int): Int {
            if (j == t.length) return 1
            if (i == s.length) return 0
            if (Pair(i, j) in cache) return cache[Pair(i, j)]!!

            if (s[i] == t[j]) {
                cache[Pair(i, j)] = dfs(i + 1, j + 1) + dfs(i + 1, j)
            } else {
                cache[Pair(i, j)] = dfs(i + 1, j)
            }

            return cache[Pair(i, j)]!!
        }

        return dfs(0, 0)
    }
}
