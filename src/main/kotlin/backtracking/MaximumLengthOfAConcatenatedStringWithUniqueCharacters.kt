package backtracking

class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
    fun maxLength(arr: List<String>): Int {
        if (arr.size == 1) return arr[0].length

        var result = 0

        fun isValid(s: String): Boolean {
            val chars = mutableSetOf<Char>()
            for (c in s) {
                if (c in chars) return false
                chars.add(c)
            }

            return true
        }

        fun backtrack(i: Int, s: String) {
            val isValid = isValid(s)
            if (isValid) {
                result = maxOf(result, s.length)
            }

            if (i == arr.size || !isValid) return


            for (j in i until arr.size) {
                backtrack(j + 1, "$s${arr[j]}")
            }
        }

        backtrack(0, "")
        return result
    }
}

fun main() {
    val solution = MaximumLengthOfAConcatenatedStringWithUniqueCharacters()
    solution.maxLength(
        listOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p")
    )
}
