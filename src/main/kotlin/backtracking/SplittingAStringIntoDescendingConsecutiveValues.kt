package backtracking

import java.math.BigInteger

class SplittingAStringIntoDescendingConsecutiveValues {
    fun splitString(s: String): Boolean {

        fun backtrack(idx: Int, prev: BigInteger): Boolean {
            if (idx == s.length) return true

            for (i in idx until s.length) {
                val value = s.substring(idx, i + 1).toBigInteger()
                if (value.plus(BigInteger.ONE) == prev && backtrack(i + 1, value)) {
                    return true
                }
            }

            return false
        }

        for (i in 0 until s.length - 1) {
            val value = s.substring(0, i + 1).toBigInteger()
            if (backtrack(i + 1, value)) return true
        }

        return false
    }
}

fun main() {
    val solution = SplittingAStringIntoDescendingConsecutiveValues()
    solution.splitString("050043")
}
