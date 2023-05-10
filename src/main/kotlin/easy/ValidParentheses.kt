package easy

import java.util.*

class ValidParentheses {

    fun isValid(s: String): Boolean {
        val stack = Stack<String>()
        for (char in s) {
            when (char) {
                '[' -> stack.push("$char")
                '(' -> stack.push("$char")
                '{' -> stack.push("$char")
                ']' -> {
                    val polled = stack.pop()
                    if (polled != "[") return false
                }
                ')' -> {
                    val polled = stack.pop()
                    if (polled != "(") return false
                }
                '}' -> {
                    val polled = stack.pop()
                    if (polled != "{") return false
                }
            }
        }

        return stack.isEmpty()
    }

}

fun main() {
    val validParentheses = ValidParentheses()
    println(validParentheses.isValid("()"))
    println(validParentheses.isValid("()[]{}"))
    println(validParentheses.isValid("(]"))
    println(validParentheses.isValid("([)]"))
}
