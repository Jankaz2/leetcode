package arrays_and_hashing

class BestTimeToBuyAndSellStockII {
    fun maxProfit(prices: IntArray): Int {
        val cache = mutableMapOf<Pair<Int, Boolean>, Int>()
        fun dfs(i: Int, canBuy: Boolean): Int {
            if (i >= prices.size) return 0
            if (Pair(i, canBuy) in cache) return cache[Pair(i, canBuy)]!!

            if (canBuy) {
                val buy = dfs(i + 1, false) - prices[i]
                val notBuy = dfs(i + 1, true)
                cache[Pair(i, canBuy)] = maxOf(buy, notBuy)
            } else {
                val sell = dfs(i + 1, true) + prices[i]
                val notSell = dfs(i + 1, false)
                cache[Pair(i, canBuy)] = maxOf(sell, notSell)
            }

            return cache[Pair(i, canBuy)]!!
        }

        return dfs(0, true)
    }

    fun maxProfit2(prices: IntArray): Int {
        var maxProfit = 0
        for (i in 1 .. prices.lastIndex) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1]
            }
        }
        return maxProfit
    }
}
