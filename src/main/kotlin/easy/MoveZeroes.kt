package easy

class MoveZeroes {

    fun moveZeroes(nums: IntArray) {
        var firstZeroIndex = 0
        for (i in nums.indices) {
            if (nums[i] != 0) {
                nums[firstZeroIndex] = nums[i]
                firstZeroIndex++
            }
        }

        for (i in firstZeroIndex until nums.size) {
            nums[i] = 0
        }
    }

}

fun main() {
    val solution = MoveZeroes()
    val arr = intArrayOf(0, 1, 0, 3, 12)
    val arr2 = intArrayOf(4, 2, 4, 0, 0, 3, 0, 5, 1, 0)
    solution.moveZeroes(arr)
    solution.moveZeroes(arr2)
    arr2.forEach { print("$it ") }
}
