package binary_search

class BinarySearch {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = left + ((right - left ) / 2)
            if (nums[mid] == target) return mid
            else if (nums[mid] > target) {
                right = mid - 1
            } else if (nums[mid] < target) {
                left = mid + 1
            }
        }

        return -1
    }

    fun recursiveSearch(nums: IntArray, target: Int, left: Int, right: Int): Int {
        val mid = left + ((right - left) / 2)

        if (right < left) return -1
        return if (target == nums[mid]) {
            mid
        } else if (target < nums[mid]) {
            recursiveSearch(nums, target, left, mid - 1)
        } else {
            recursiveSearch(nums, target, mid + 1, right)
        }
    }
}

fun main() {
    val solution = BinarySearch()
    println(solution.search(intArrayOf(-1, 0, 3, 5, 9, 12), 9))
    println(solution.recursiveSearch(intArrayOf(-1, 0, 3, 5, 9, 12), 9, 0, 5))
    println(solution.search(intArrayOf(-1, 0, 3, 5, 9, 12), 2))
    println(solution.recursiveSearch(intArrayOf(-1, 0, 3, 5, 9, 12), 2, 0, 5))
}
