package linkedlist

class FindTheDuplicateNumber {
    fun findDuplicate(nums: IntArray): Int {
        var slow = 0
        var slow2 = 0
        var fast = 0
        do {
            slow = nums[slow]
            fast = nums[nums[fast]]
        } while (slow != fast)

        do {
            slow2 = nums[slow2]
            slow = nums[slow]
        } while (slow2 != slow)

        return slow
    }
}

fun main() {
    val solution = FindTheDuplicateNumber()
    println(solution.findDuplicate(intArrayOf(1, 3, 4, 2, 2)))
    println(solution.findDuplicate(intArrayOf(3, 1, 3, 4, 2)))
    println(solution.findDuplicate(intArrayOf(2, 2, 2, 2, 2)))
}
