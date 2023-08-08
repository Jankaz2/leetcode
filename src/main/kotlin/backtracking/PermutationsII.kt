package backtracking

class PermutationsII {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val count = mutableMapOf<Int, Int>()
        val result = mutableListOf<MutableList<Int>>()

        for (n in nums) {
            count[n] = count.getOrDefault(n, 0) + 1
        }

        fun backtrack(current: MutableList<Int>) {
            if (current.size == nums.size) {
                result.add(ArrayList(current))
                return
            }

            for (n in count.keys) {
                if (count[n] == 0) continue

                count[n] = count[n]!! - 1
                current.add(n)
                backtrack(current)
                current.removeAt(current.lastIndex)
                count[n] = count[n]!! +  1
            }
        }

        backtrack(mutableListOf())
        return result
    }
}

fun main() {
    val solution = PermutationsII()
    solution.permuteUnique(intArrayOf(1, 1, 2))
}
