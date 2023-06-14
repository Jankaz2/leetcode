package medium

class SubsetsII {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        nums.sort()
        backtracking(nums, result, mutableListOf(), 0)
        return result
    }

    private fun backtracking(nums: IntArray, result: MutableList<MutableList<Int>>, current: MutableList<Int>, index: Int) {

        result.add(ArrayList(current))

        for (i in index until nums.size) {
            if (i > index && nums[i] == nums [i-1]) {
                continue
            }

            current.add(nums[i])
            backtracking(nums, result, current, i + 1)
            current.removeAt(current.size - 1)
        }
    }
}

fun main() {
    val solution = SubsetsII()
    solution.subsetsWithDup(intArrayOf(1, 2, 2))
}
