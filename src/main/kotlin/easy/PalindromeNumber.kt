package easy

import kotlin.Boolean
import kotlin.Int
import kotlin.math.pow

class PalindromeNumber {

    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false

        var reversedNumber = 0
        var multiplier = 10.0.pow((x.toString().length - 1).toDouble()).toInt()
        var temp = x
        while (temp > 0) {
            val digit = temp % 10
            reversedNumber += digit * multiplier
            temp /= 10
            multiplier /= 10
        }

        return reversedNumber == x
    }
}

fun main() {
    val p = PalindromeNumber()
    println(p.isPalindrome(121))
}
