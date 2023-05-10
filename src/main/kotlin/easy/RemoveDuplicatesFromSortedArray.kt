package easy

class RemoveDuplicatesFromSortedArray {

    fun removeDuplicates(nums: IntArray): Int {
        var idx = 0
        for (i in 1 until nums.size) {
            if (nums[i] != nums[idx]) {
                idx++
                nums[idx] = nums[i]
            }
        }

        return idx + 1
    }

    fun removeDuplicates2(nums: IntArray): Int {
        val resultSet = sortedSetOf(*nums.toTypedArray())
        for (i in resultSet.indices) {
            nums[i] = resultSet.elementAt(i)
        }
        return resultSet.size
    }
}

fun main() {
    val solution = RemoveDuplicatesFromSortedArray()
    println(solution.removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)))
}

