package sliding_window

class LongestSubstringWithoutRepeatingCharacters {
    fun lengthOfLongestSubstring(s: String): Int {
        val hs = HashSet<Char>()
        var i = 0
        var j = 0
        var maxLength = 0
        while (j < s.length) {
            if (hs.contains(s[j])) {
                hs.remove(s[i++])
            } else {
                hs.add(s[j++])
                maxLength = maxLength.coerceAtLeast(hs.size)
            }
        }
        return maxLength
    }
}

fun main() {
    val solution = LongestSubstringWithoutRepeatingCharacters()
//    println(solution.lengthOfLongestSubstring("abcabcbb"))
//    println(solution.lengthOfLongestSubstring("bbbbbbb"))
//    println(solution.lengthOfLongestSubstring("pwwkew"))
    println(solution.lengthOfLongestSubstring("dvvf"))
}
