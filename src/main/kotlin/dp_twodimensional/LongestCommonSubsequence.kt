package dp_twodimensional

class LongestCommonSubsequence {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val dp = Array(text1.length + 1) { IntArray(text2.length + 1) }

        for (i in text1.length - 1 downTo 0) {
            for (j in text2.length - 1 downTo 0) {
                if (text1[i] == text2[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1
                } else {
                    dp[i][j] = maxOf(dp[i + 1][j], dp[i][j + 1])
                }
            }
        }

        return dp[0][0]
    }
}

fun main() {
    val solution = LongestCommonSubsequence()
    solution.longestCommonSubsequence("ezupkr", "ubmrapg")
}
