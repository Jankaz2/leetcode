package easy

class RomanToInteger {

    fun romanToInt(s: String): Int {
        var result = 0
        var number = 0
        for (i in s.length - 1 downTo 0) {
            when (s[i]) {
                'I' -> number = 1
                'V' -> number = 5
                'X' -> number = 10
                'L' -> number = 50
                'C' -> number = 100
                'D' -> number = 500
                'M' -> number = 1000
            }

            if (4 * number < result) {
                result -= number
            } else {
                result += number
            }
        }

        return result
    }

}

fun main() {
    val romanToInteger = RomanToInteger()
    println(romanToInteger.romanToInt("III"))
    println(romanToInteger.romanToInt("LVIII"))
    println(romanToInteger.romanToInt("MCMXCIV"))
}
