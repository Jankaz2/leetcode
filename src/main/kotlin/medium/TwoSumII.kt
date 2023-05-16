package medium

class TwoSumII {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var min = 0
        var max = numbers.size - 1
        while (min < max) {
            when {
                numbers[min] + numbers[max] == target -> return intArrayOf(min + 1, max + 1)
                numbers[min] + numbers[max] < target -> min++
                else -> max--
            }
        }
        return intArrayOf()
    }
}

fun main() {
    val solution = TwoSumII()
    solution.twoSum(intArrayOf(2, 7, 11, 15), 9).forEach { print("$it ") }
}
