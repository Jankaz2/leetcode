package binary_search

class FindMinimumInRotatedSortedArray {
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.lastIndex
        var result = nums[nums.size / 2]

        while (left <= right) {
            val mid = left + (right - left) / 2
            if (nums[left] < nums[right]) {
                result = result.coerceAtMost(nums[left])
                break
            }

            result = result.coerceAtMost(nums[mid])
            if (nums[mid] >= nums[left]) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return result
    }
}

fun main() {
    val solution = FindMinimumInRotatedSortedArray()
    println(solution.findMin(intArrayOf(3, 4, 5, 1, 2)))
    println(solution.findMin(intArrayOf(4, 5, 6, 7, 0, 1, 2)))
    println(solution.findMin(intArrayOf(11, 13, 15, 17)))
    println(solution.findMin(intArrayOf(2, 1)))
    println(solution.findMin(intArrayOf(3, 1, 2)))
}
