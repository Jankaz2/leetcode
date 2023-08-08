package backtracking

class RestoreIpAddresses {
    fun restoreIpAddresses(s: String): List<String> {
        val res = mutableListOf<String>()

        if (s.length > 12) return res

        fun backtrack(idx: Int, dots: Int, currIP: String) {
            if (dots == 4 && idx == s.length) {
                res.add(currIP.substring(0, currIP.length - 1))
                return
            }

            if (dots > 4) {
                return
            }

            for (j in idx until minOf(idx + 3, s.length)) {
                val segment = s.substring(idx, j + 1)
                if ((segment.toInt() < 256)) {
                    if (segment.length > 1 && segment[0] == '0') continue
                    backtrack(j + 1, dots + 1, "$currIP$segment.")
                }
            }
        }

        backtrack(0, 0, "")
        return res
    }

}

fun main() {
    val solution = RestoreIpAddresses()
    solution.restoreIpAddresses("25525511135")
}
