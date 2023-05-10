package easy

class ContainsDuplicate {
    fun containsDuplicate(nums: IntArray): Boolean {
        val set = hashSetOf<Int>()
        for (i in nums) {
            if (set.contains(i)) return true
            set.add(i)
        }
        return false
    }
}

fun main() {
    val solution = ContainsDuplicate()
    println(solution.containsDuplicate(intArrayOf(1, 2, 3, 1)))
    println(solution.containsDuplicate(intArrayOf(1, 2, 3, 4)))
    println(solution.containsDuplicate(intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)))
}
