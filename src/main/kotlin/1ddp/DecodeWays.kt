package `1ddp`

class DecodeWays {
    fun numDecodings(s: String): Int {
        if (s.isEmpty() || s[0] - '0' == 0) {
            return 0
        }

        val waysToDecode = IntArray(s.length + 1)
        waysToDecode[0] = 1 // empty string
        waysToDecode[1] = 1

        // Keep in mind that the indices are adjusted for the cache because its size differs from the string size.
        for (i in 1 until s.length) {
            val curr = s[i] - '0'
            val prev = s[i - 1] - '0'
            val prevWithCurrAsNum = prev * 10 + curr

            // can't decode the entire string, return 0
            if (prev == 0 && curr == 0 || (curr == 0 && prevWithCurrAsNum > 26)) {
                return 0
            } else if (prev == 0 || prevWithCurrAsNum > 26) {
                waysToDecode[i + 1] = waysToDecode[i]
            } else if (curr == 0) {
                waysToDecode[i + 1] = waysToDecode[i - 1]
            } else {
                waysToDecode[i + 1] = waysToDecode[i] + waysToDecode[i - 1]
            }
        }

        return waysToDecode.last()
    }
}

fun main() {
    val solution = DecodeWays()
    solution.numDecodings("11106")
}
