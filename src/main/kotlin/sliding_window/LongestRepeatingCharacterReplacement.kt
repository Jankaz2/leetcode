package sliding_window

class LongestRepeatingCharacterReplacement {
    fun characterReplacement(s: String, k: Int): Int {
        val frequences = IntArray(26) { 0 }
        var result = 0
        var currentMax = 0
        var start = 0

        for (end in s.indices) {
            val count = ++frequences[s[end] - 'A']
            currentMax = currentMax.coerceAtLeast(count)

            if (end - start + 1 > currentMax + k) {
                frequences[s[start] - 'A']--
                start++
            }

            result = result.coerceAtLeast(end - start + 1)
        }

        return result
    }
}

fun main() {
    val solution = LongestRepeatingCharacterReplacement()
    println(solution.characterReplacement("ABAB", 2))
    println(solution.characterReplacement("AABABBA", 1))
    println(solution.characterReplacement("AAAA", 2))
}
