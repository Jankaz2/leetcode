package easy

import java.math.BigInteger

class PlusOne {

    fun plusOne2(digits: IntArray): IntArray {
        var digitsCopy = digits.copyOf()
        for (i in digitsCopy.size - 1 downTo 0) {
            if (digitsCopy[i] < 9) {
                digitsCopy[i]++
                return digitsCopy
            }
            digitsCopy[i] = 0
        }

        digitsCopy = IntArray(digitsCopy.size + 1)
        digitsCopy[0] = 1
        return digitsCopy
    }

    fun plusOne(digits: IntArray): IntArray {
        return digits
            .joinToString("")
            .toBigInteger()
            .plus(BigInteger.ONE)
            .toString()
            .map { it.toString().toInt() }
            .toIntArray()
    }
}

fun main() {
    val solution = PlusOne()
    println(solution.plusOne2(intArrayOf(1, 2, 3)))
    println(solution.plusOne2(intArrayOf(4, 3, 2, 1)))
    println(solution.plusOne2(intArrayOf(9)))
}
