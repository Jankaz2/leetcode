package easy

class RemoveElement {
    fun removeElement2(nums: IntArray, `val`: Int): Int {
        var lastNotToRemoveIdx = 0
        nums.forEach {
            if (it != `val`) nums[lastNotToRemoveIdx++] = it
        }

        return lastNotToRemoveIdx
    }
}

fun main() {
    val solution = RemoveElement()
    println(solution.removeElement2(intArrayOf(3, 2, 2, 3), 3))
    println(solution.removeElement2(intArrayOf(0, 1, 2, 2, 3, 0, 4, 2), 2))
    println(solution.removeElement2(intArrayOf(2), 3))
    println(solution.removeElement2(intArrayOf(3, 3), 5))
}
