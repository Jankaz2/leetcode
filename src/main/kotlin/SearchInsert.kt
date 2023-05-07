class SearchInsert {
    fun searchInsert(nums: IntArray, target: Int): Int {
        nums.forEachIndexed { i, num ->
            if (num == target || num > target) {
                return i
            }
            if (i == nums.size - 1) {
                return i + 1
            }
        }

        return -1
    }
}

fun main() {
    val solution = SearchInsert()
    println(solution.searchInsert(intArrayOf(1, 3, 5, 6), 5))
    println(solution.searchInsert(intArrayOf(1, 3, 5, 6), 2))
    println(solution.searchInsert(intArrayOf(1, 3, 5, 6), 7))
    println(solution.searchInsert(intArrayOf(1, 3, 5, 6), 0))
    println(solution.searchInsert(intArrayOf(1, 3), 2))
    println(solution.searchInsert(intArrayOf(1), 1))
}
