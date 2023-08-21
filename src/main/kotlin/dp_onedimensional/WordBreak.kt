package dp_onedimensional

class WordBreak {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        if (s.isEmpty() || wordDict.isEmpty()) return false

        val dp = BooleanArray(s.length + 1)
        dp[dp.lastIndex] = true

        for (i in s.length - 1 downTo 0) {
            for (word in wordDict) {
                if (i + word.length <= s.length && s.substring(i, i + word.length) == word) {
                    dp[i] = dp[i + word.length]
                }

                if (dp[i]) break
            }
        }

        return dp[0]
    }
}

fun main() {
    val solution = WordBreak()
    solution.wordBreak("applepenapple", listOf("apple", "pen"))
}
