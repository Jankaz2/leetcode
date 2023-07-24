package `1ddp`

class PalindromicSubstrings {

    fun countSubstrings(s: String): Int {
        if (s.isEmpty()) return 0
        var counter = 0

        fun expandFromMiddle(left: Int, right: Int) {
            var l = left
            var r = right
            while (l >= 0 && r < s.length && s[l] == s[r]) {
                l--
                r++
                counter++
            }
        }

        for (i in s.indices) {
            expandFromMiddle(i, i)
            expandFromMiddle(i, i + 1)
        }

        return counter
    }

}
