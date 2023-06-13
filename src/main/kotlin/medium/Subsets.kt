package medium

class Subsets {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = ArrayList<ArrayList<Int>>()
        val current = ArrayList<Int>()

        fun dfs(index: Int) {
            if (index >= nums.size) {
                result.add(ArrayList(current))
                return
            }

            // left decision subtree
            current.add(nums[index])
            dfs(index + 1)
            current.removeLast()
            // right decision subtree
            dfs(index + 1)
        }
        dfs(0)
        return result
    }


    fun subsets2(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        backtracking(nums, mutableListOf(), result, 0)
        return result
    }

    private fun backtracking(
        nums: IntArray,
        set: MutableList<Int>,
        result: MutableList<MutableList<Int>>,
        start: Int
    ) {
        result.add(ArrayList(set))
        for (i in start until nums.size) {
            set.add(nums[i])
            backtracking(nums, set, result, i + 1)
            set.removeAt(set.size - 1)
        }
    }
}

fun main() {
    val solution = Subsets()
    val nums = intArrayOf(1, 2, 3)
    solution.subsets2(nums)
}
