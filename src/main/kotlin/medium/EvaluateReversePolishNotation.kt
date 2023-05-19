package medium

import java.util.Stack

class EvaluateReversePolishNotation {
    fun evalRPN(tokens: Array<String>): Int {
        if (tokens.size == 1) return tokens[0].toInt()
        val stack = Stack<Int>()
        var sum = 0
        for (token in tokens) {
            if (token.toIntOrNull() != null) {
                stack.push(token.toInt())
            } else {
                val secondElement = stack.pop()
                val firstElement = stack.pop()
                sum = doMath(firstElement, secondElement, token)
                stack.push(sum)
            }
        }
        return sum
    }

    private fun doMath(firstElement: Int, secondElement: Int, operator: String): Int {
        return when (operator) {
            "+" -> firstElement + secondElement
            "-" -> firstElement - secondElement
            "*" -> firstElement * secondElement
            "/" -> firstElement / secondElement
            else -> 0
        }
    }

}

fun main() {
    val solution = EvaluateReversePolishNotation()
    println(solution.evalRPN(arrayOf("2", "1", "+", "3", "*")))
    println(solution.evalRPN(arrayOf("4", "13", "5", "/", "+")))
    println(solution.evalRPN(arrayOf("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+")))
}
