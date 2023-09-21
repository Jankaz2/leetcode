package arrays_and_hashing

class MaximumProductOfTheLengthOfTwoPalindromicSubsequences {
    fun maxProduct(s: String): Int {
        val hm = HashMap<Int, Int>()

        for (mask in 1 until (1 shl s.length)) {
            val sb = StringBuilder()

            for (i in s.indices) {
                if (mask and (1 shl i) > 0) {
                    sb.append(s[i])
                }
            }

            val p = sb.toString()
            if (p == p.reversed()) {
                hm[mask] = p.length
            }
        }

        var max = 0
        for (mask1 in hm.keys) {
            for (mask2 in hm.keys) {
                if (mask1 and mask2 == 0) {
                    max = maxOf(
                        max,
                        hm[mask1]!! * hm[mask2]!!
                    )
                }
            }
        }

        return max
    }
}
