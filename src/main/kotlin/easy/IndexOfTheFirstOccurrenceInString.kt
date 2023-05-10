package easy

class IndexOfTheFirstOccurrenceInString {

    fun strStr(haystack: String, needle: String): Int {
        val needleLength = needle.length
        val haystackLength = haystack.length
        var i = 0
        var needleIndex = 0

        while (i < haystackLength) {
            if (haystack[i] == needle[needleIndex]) {
                needleIndex++
            } else {
                i -= needleIndex
                needleIndex = 0
            }

            i++

            if (needleIndex == needleLength)  return i - needleIndex
        }

        return -1
    }

    fun strStr2(haystack: String, needle: String): Int {
        var result = -1
        var idx = 0
        while (idx + needle.length <= haystack.length) {
            if (haystack.substring(idx, idx + needle.length) == needle) {
                result = idx
                break
            }
            idx++
        }
        return result
    }
}

fun main() {
    val solution = IndexOfTheFirstOccurrenceInString()
    println(solution.strStr("sadbutsad", "sad"))
    println(solution.strStr("leetcode", "leeto"))
}
