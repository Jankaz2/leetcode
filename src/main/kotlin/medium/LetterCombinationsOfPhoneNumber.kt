package medium

class LetterCombinationsOfPhoneNumber {

    private var nums = mapOf(
        '2' to listOf('a', 'b', 'c'),
        '3' to listOf('d', 'e', 'f'),
        '4' to listOf('g', 'h', 'i'),
        '5' to listOf('j', 'k', 'l'),
        '6' to listOf('m', 'n', 'o'),
        '7' to listOf('p', 'q', 'r', 's'),
        '8' to listOf('t', 'u', 'v'),
        '9' to listOf('w', 'x', 'y', 'z')
    )

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()
        val result = mutableListOf<String>()
        backtracking(digits, StringBuilder(), result, 0)
        return result
    }

    private fun backtracking(
        digits: String,
        current: StringBuilder,
        result: MutableList<String>,
        digitsIndex: Int
    ) {
        if (current.length == digits.length) {
            result.add(current.toString())
            return
        }

        val listOfChars = nums.getValue(digits[digitsIndex])

        for (c in listOfChars) {
            current.append(c)
            backtracking(digits, current, result, digitsIndex + 1)
            current.deleteCharAt(current.length - 1)
        }
    }
}

fun main() {
    val solution = LetterCombinationsOfPhoneNumber()
    val result = solution.letterCombinations("23")
    result.forEach {
        println(it)
    }
}
