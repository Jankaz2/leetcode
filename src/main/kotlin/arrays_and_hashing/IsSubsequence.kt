package arrays_and_hashing

class IsSubsequence {
    fun isSubsequence(s: String, t: String): Boolean {
        if (t.length < s.length) return false

        var i = 0
        var j = 0

        while (i < s.length && j < t.length) {
            if (s[i] == t[j]) {
                i++
                j++
            } else {
                j++
            }
        }

        return i == s.lastIndex
    }
}

fun main() {
    val solution = IsSubsequence()
    solution.isSubsequence("abc", "abhgdc")
}
