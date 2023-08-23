package dp_twodimensional

class LongestPalindromicSubsequence {
    fun longestPalindromeSubseq(s: String): Int {
        val SIZE = s.length
        val dp = Array(SIZE + 1) { IntArray(SIZE + 1) }
        val reversed = s.reversed()

        for (i in s.length - 1 downTo 0) {
            for (j in reversed.length - 1 downTo 0) {
                if (s[i] == reversed[j]) {
                    dp[i][j] = 1 + dp[i + 1][j + 1]
                } else {
                    dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
                }
            }
        }

        return dp[0][0]
    }

    fun longestPalindromeSubseqRecursion(s: String): Int {
        val cache = mutableMapOf<Pair<Int, Int>, Int>()

        fun dfs(l: Int, r: Int): Int {
            if (l < 0 || r == s.length) {
                return 0
            }

            if (Pair(l, r) in cache) {
                return cache[Pair(l, r)]!!
            }

            if (s[l] == s[r]) {
                val length = if (l == r) 1 else 2
                cache[Pair(l, r)] = length + dfs(l - 1, r + 1)
            } else {
                cache[Pair(l, r)] = maxOf(dfs(l - 1, r), dfs(l, r + 1))
            }

            return cache[Pair(l, r)]!!
        }

        for (i in s.indices) {
            dfs(i, i)
            dfs(i, i + 1)
        }

        return cache.values.max()
    }
}

fun main() {
    val solution = LongestPalindromicSubsequence()
    solution.longestPalindromeSubseq("cbbd")
}
