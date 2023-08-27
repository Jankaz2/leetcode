package dp_twodimensional

class CoinChangeII {
    fun change(amount: Int, coins: IntArray): Int {
        val dp = Array(coins.size) { IntArray(amount + 1) }

        for (i in coins.indices) dp[i][0] = 1

        for (i in coins.indices) {
            for (j in 1..amount) {
                if (i > 0) {
                    dp[i][j] += dp[j - 1][j]
                }
                if (j >= coins[i]) {
                    dp[i][j] = dp[i][j - coins[i]]
                }
            }
        }

        return dp[coins.lastIndex][amount]
    }

    fun change2(amount: Int, coins: IntArray): Int {
        val dp = IntArray(amount + 1)

        dp[0] = 1
        for (coin in coins) {
            for (i in 1..amount) {
                if (i - coin >= 0)
                    dp[i] += dp[i - coin]
            }
        }

        return dp[amount]
    }
}

fun main() {
    val solution = CoinChangeII()
    solution.change2(5, intArrayOf(1, 2, 5))
}
