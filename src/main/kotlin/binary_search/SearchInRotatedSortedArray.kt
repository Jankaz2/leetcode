package binary_search

class SearchInRotatedSortedArray {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex

        while (left <= right) {
            val mid = left + (right - left) / 2
            if (nums[mid] == target) {
                return mid
            }

            if (nums[mid] >= nums[left]) {
                if (target < nums[left] || target > nums[mid]) {
                    left = mid + 1
                } else {
                    right = mid - 1
                }
            } else {
                if (target < nums[mid] || target > nums[right]) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }
        }

        return -1
    }
}

fun main() {
    val solution = SearchInRotatedSortedArray()
    println(solution.search(intArrayOf(5, 1, 3), 5))
    println(solution.search(intArrayOf(1, 3), 3))
    println(solution.search(intArrayOf(4, 5, 6, 0, 1, 2, 3), 1))
    println(solution.search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3))
    println(solution.search(intArrayOf(1), 0))
}
