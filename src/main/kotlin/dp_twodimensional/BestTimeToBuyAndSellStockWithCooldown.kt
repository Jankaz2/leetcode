package dp_twodimensional

class BestTimeToBuyAndSellStockWithCooldown {

    fun maxProfit(prices: IntArray): Int {
        val cache = mutableMapOf<Pair<Int, Boolean>, Int>()

        fun dfs(i: Int, canBuy: Boolean): Int {
            if (i >= prices.size) return 0

            if (Pair(i, canBuy) in cache) return cache[Pair(i, canBuy)]!!

            val cooldown = dfs(i + 1, canBuy)
            if (canBuy) {
                val buy = dfs(i + 1, !canBuy) - prices[i]
                cache[Pair(i, canBuy)] = maxOf(buy, cooldown)
            } else {
                val sell = dfs(i + 2, !canBuy) + prices[i]
                cache[Pair(i, canBuy)] = maxOf(sell, cooldown)
            }

            return cache[Pair(i, canBuy)]!!
        }

        return dfs(0, true)
    }
}
