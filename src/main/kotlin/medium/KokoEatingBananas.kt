package medium

import kotlin.math.ceil

class KokoEatingBananas {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var l = 1
        var r = piles.maxOrNull() ?: 0
        var result = piles.maxOrNull() ?: 0

        while (l < r) {
            val k = (r + l) / 2
            var hours = 0
            for (pile in piles) {
                hours += ceil(pile / k.toDouble()).toInt()
            }
            if (hours > h) {
                l = k + 1
            } else {
                result = result.coerceAtMost(k)
                r = k
            }
        }

        return result
    }
}

fun main() {
    val solution = KokoEatingBananas()
    println(solution.minEatingSpeed(intArrayOf(3, 6, 7, 11), 8))
    println(solution.minEatingSpeed(intArrayOf(30, 11, 23, 4, 20), 5))
    println(solution.minEatingSpeed(intArrayOf(30, 11, 23, 4, 20), 6))
    println(solution.minEatingSpeed(intArrayOf(805306368, 805306368, 805306368), 1000000000))
}
