package easy

class BestTimeToBuyAndSellStock {
    fun maxProfit(prices: IntArray): Int {
        var buy = prices[0]
        var maxDiff = 0
        for (i in 1 until prices.size) {
            buy = buy.coerceAtMost(prices[i])
            maxDiff = maxDiff.coerceAtLeast(prices[i] - buy)
        }
        return maxDiff
    }
}

fun main() {
    val solution = BestTimeToBuyAndSellStock()
    println(solution.maxProfit(intArrayOf(1, 2, 4, 2, 5, 7, 2, 4, 9, 0, 9)))
    //println(solution.maxProfit(intArrayOf(7, 6, 4, 3, 1)))
}
