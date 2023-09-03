package dp_twodimensional

class CountVowelsPermutation {
    fun countVowelPermutation(n: Int): Int {
        val dp = Array(n + 1) { IntArray(5) { 1 } }
        val mod = 1000000007
        val a = 0
        val e = 1
        val i = 2
        val o = 3
        val u = 4

        for (j in 2..n) {
            dp[j][a] = (((dp[j - 1][e] + dp[j - 1][i]) % mod) + dp[j - 1][u]) % mod
            dp[j][e] = (dp[j - 1][a] + dp[j - 1][i]) % mod
            dp[j][i] = (dp[j - 1][e] + dp[j - 1][o]) % mod
            dp[j][o] = dp[j - 1][i]
            dp[j][u] = (dp[j - 1][i] + dp[j - 1][o]) % mod
        }

        var sum = 0

        for (index in 0..4) {
            sum = (sum + dp[n][index]) % mod
        }

        return sum
    }
}

fun main() {
    val solution = CountVowelsPermutation()
    solution.countVowelPermutation(2)
}
