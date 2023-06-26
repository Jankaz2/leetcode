package two_pointers

class ValidPalindrome {

    fun isPalindrome(s: String): Boolean {
        var i = 0
        var j = s.length - 1
        while (i <= j) {
            while (!s[i].isLetterOrDigit() && i < s.length - 1) { i++ }
            while (!s[j].isLetterOrDigit() && j > 0) { j-- }
            if (s[i].lowercase() != s[j].lowercase()) return false
            i++; j--
        }

        return true
    }
}

fun main() {
    val solution = ValidPalindrome()
    println(solution.isPalindrome(".,"))
    println(solution.isPalindrome("A man, a plan, a canal: Panama"))
    println(solution.isPalindrome("race a car"))
    println(solution.isPalindrome(" "))
}
