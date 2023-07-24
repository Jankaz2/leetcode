package `1ddp`

class LongestPalindromicSubstring {

    var result: String = ""
    var resultLength: Int = 0

    fun longestPalindrome(s: String): String {
        if (s.isEmpty()) {
            return ""
        }

        for (i in s.indices) {
            expandFromMiddle(s, i, i) // odd length
            expandFromMiddle(s, i, i + 1) // even length
        }

        return result
    }

    private fun expandFromMiddle(s: String, left: Int, right: Int) {
        var l = left
        var r = right
        if (l > r) return

        while (l >= 0 && r < s.length && s[l] == s[r]) {
            if (r - l + 1 > resultLength) {
                result = s.substring(l, r + 1)
                resultLength = r - l + 1
            }
            l--
            r++
        }

    }
}
