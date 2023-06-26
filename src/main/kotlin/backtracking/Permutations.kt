package backtracking

class Permutations {
    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        permuteBacktracking(nums, mutableListOf(), result)
        return result
    }

    private fun permuteBacktracking(
        nums: IntArray,
        current: MutableList<Int>,
        result: MutableList<MutableList<Int>>,
    ) {

        if (current.size == nums.size) {
            result.add(ArrayList(current))
            return
        }

        for (num in nums) {
            if (current.contains(num)) continue

            current.add(num)
            permuteBacktracking(nums, current, result)
            current.removeAt(current.size - 1)
        }
    }
}

fun main() {
    val solution = Permutations()
    val res = solution.permute(intArrayOf(1, 2, 3))
    res.forEach {
        println(it.map { el -> "$el" })
    }
}
