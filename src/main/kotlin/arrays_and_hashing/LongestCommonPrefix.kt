package arrays_and_hashing

class LongestCommonPrefix {

    fun longestCommonPrefix(strs: Array<String>): String {
        strs.sort()
        val first = strs[0]
        var prefix = ""
        val last = strs[strs.size - 1]
        for (i in first.indices) {
            if (first[i] != last[i]) break
            prefix += first[i]
        }
        return prefix
    }

}

fun main() {
    val longestCommonPrefix = LongestCommonPrefix()
    println(longestCommonPrefix.longestCommonPrefix(arrayOf("a")))
    println(longestCommonPrefix.longestCommonPrefix(arrayOf("")))
    println(longestCommonPrefix.longestCommonPrefix(arrayOf("flower", "flow", "flight")))
    println(longestCommonPrefix.longestCommonPrefix(arrayOf("dog", "racecar", "car")))
}
