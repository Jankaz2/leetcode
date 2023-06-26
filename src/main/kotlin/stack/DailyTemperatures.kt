package stack

import java.util.*

class DailyTemperatures {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val stack = Stack<Int>()
        val res = IntArray(temperatures.size) { 0 }
        for (i in temperatures.lastIndex downTo 0) {
            while (stack.isNotEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop()
            }
            if (stack.isNotEmpty()) {
                res[i] = stack.peek() - i
            }
            stack.push(i)
        }
        return res
    }
}

fun main() {
    val solution = DailyTemperatures()
    solution.dailyTemperatures(intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)).forEach { print("$it ") }
    println()
    solution.dailyTemperatures(intArrayOf(30, 40, 50, 60)).forEach { print("$it ") }
    println()
    solution.dailyTemperatures(intArrayOf(30, 60, 90)).forEach { print("$it ") }
}
