package easy

class FirstRecurringCharacter {
    fun firstRecurringCharacter(arr: IntArray): Int? {
        val set = hashSetOf<Int>()
        for (num in arr) {
            if (set.contains(num)) {
                return num
            }
            set.add(num)
        }
        return null
    }
}

fun main() {
    val solution = FirstRecurringCharacter()
    println(solution.firstRecurringCharacter(intArrayOf(2, 5, 1, 2, 3, 5, 1, 2, 4)))
    println(solution.firstRecurringCharacter(intArrayOf(2, 1, 1, 2, 3, 5, 1, 2, 4)))
    println(solution.firstRecurringCharacter(intArrayOf(2, 3, 4, 5)))
}
