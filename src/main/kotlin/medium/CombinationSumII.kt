package medium

class CombinationSumII {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        candidates.sort()
        search(candidates, target, mutableListOf(), result, 0)
        return result
    }

    private fun search(candidates: IntArray, target: Int, current: MutableList<Int>, result: MutableList<MutableList<Int>>, index: Int) {
        if (target == 0) {
            result.add(ArrayList(current))
            return
        }

        for (i in index until candidates.size) {
            if (i > index && candidates[i] == candidates[i - 1]) continue
            if (target - candidates[i] < 0) break

            current.add(candidates[i])
            search(candidates, target - candidates[i], current, result, i + 1)
            current.removeAt(current.size - 1)
        }
    }
}
