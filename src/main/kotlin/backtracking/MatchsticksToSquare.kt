package backtracking

class MatchsticksToSquare {
    fun makesquare(matchsticks: IntArray): Boolean {
        val matchsticksSum = matchsticks.sum()
        if (matchsticksSum % 4 != 0) return false

        val sideLength = matchsticksSum / 4
        val sides = IntArray(4)
        matchsticks.sortedWith(compareBy { -it })

        fun backtrack(idx: Int): Boolean {
            if (idx == matchsticks.size) return true

            for (i in 0 until 4) {
                if (sides[i] + matchsticks[idx] <= sideLength) {
                    sides[i] += matchsticks[idx]
                    if (backtrack(idx + 1)) {
                        return true
                    }
                    sides[i] -= matchsticks[idx]
                }
            }

            return false
        }

        return backtrack(0)
    }
}

fun main() {
    val solution = MatchsticksToSquare()
    solution.makesquare(intArrayOf(1, 1, 2, 2, 2))
}
