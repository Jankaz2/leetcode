package sliding_window

class PermutationInString {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false

        val s1Count = IntArray(26) { 0 }
        val s2Count = IntArray(26) { 0 }

        for (i in s1.indices) {
            s1Count[s1[i] - 'a']++
            s2Count[s2[i] - 'a']++
        }

        var matches = 0
        for (i in 0 until 26) {
            matches += (if (s1Count[i] == s2Count[i]) 1 else 0)
        }

        var l = 0
        for (r in s1.length until s2.length) {
            if (matches == 26) return true

            var index = s2[r] - 'a'
            s2Count[index]++

            if (s1Count[index] == s2Count[index]) {
                matches++
            } else if (s1Count[index] + 1 == s2Count[index]) {
                matches--
            }

            index = s2[l] - 'a'
            s2Count[index]--
            if (s1Count[index] == s2Count[index]) {
                matches++
            } else if (s1Count[index] - 1 == s2Count[index]) {
                matches--
            }

            l++
        }

        return matches == 26
    }
}

fun main() {
    val solution = PermutationInString()
    println(solution.checkInclusion("abc", "baxyzdabck"))
    println(solution.checkInclusion("ab", "eidboaoo"))
    println(solution.checkInclusion("adc", "dcda"))
}
