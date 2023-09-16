package arrays_and_hashing

class UniqueLength3PalindromicSubsequence {
    fun countPalindromicSubsequence(s: String): Int {
        val firstOccurence = IntArray(26) { Int.MAX_VALUE }
        val lastOccurence = IntArray(26)
        var res = 0

        for (i in s.indices) {
            firstOccurence[s[i] - 'a'] = minOf(firstOccurence[s[i] - 'a'], i)
            lastOccurence[s[i] - 'a'] = i
        }

        for (i in 0 until 26) {
            if (firstOccurence[i] < lastOccurence[i]) {
                res += s.substring(firstOccurence[i] + 1, lastOccurence[i]).toCharArray().distinct().count()
            }
        }

        return res
    }
}
