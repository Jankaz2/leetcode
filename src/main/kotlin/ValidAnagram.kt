class ValidAnagram {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val sChars = hashMapOf<Char, Int>()
        val tChars = hashMapOf<Char, Int>()

        for (i in s.indices) {
            sChars[s[i]] = sChars.getOrDefault(s[i], 0) + 1
            tChars[t[i]] = tChars.getOrDefault(t[i], 0) + 1
        }

        return tChars == sChars
    }
}

fun main() {
    val solution = ValidAnagram()
    println(solution.isAnagram("anagram", "nagaram"))
    println(solution.isAnagram("rat", "car"))
}
