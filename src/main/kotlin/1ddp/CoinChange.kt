package `1ddp`

class CoinChange {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1) { amount + 1 }
        dp[0] = 0

        for (a in 0..amount) {
            for (coin in coins) {
                if (a - coin >= 0) {
                    dp[a] = minOf(dp[a], 1 + dp[a - coin])
                }
            }
        }

        return if (dp[amount] != amount + 1) dp[amount] else -1
    }
}

fun main() {
    val solution = CoinChange()
    solution.coinChange(intArrayOf(1, 2, 5), 11)
}
