package dp_twodimensional

class EditDistance {
    fun minDistance(word1: String, word2: String): Int {
        val dp = Array(word1.length + 1) { IntArray(word2.length + 1) }
        for (row in dp.indices) {
            dp[row][dp[0].lastIndex] = word1.length - row
        }

        for (col in dp[0].indices) {
            dp[dp.lastIndex][col] = word2.length - col
        }

        for (i in word1.lastIndex downTo 0) {
            for (j in word2.lastIndex downTo 0) {
                if (word1[i] == word2[j]) {
                    dp[i][j] = dp[i + 1][j + 1]
                } else {
                    dp[i][j] = 1 + minOf(
                        dp[i + 1][j + 1], // replace
                        dp[i][j + 1],     // insert
                        dp[i + 1][j]      // delete
                    )
                }
            }
        }

        return dp[0][0]
    }
}
