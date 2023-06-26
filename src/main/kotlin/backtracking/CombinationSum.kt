package backtracking

class CombinationSum {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        search(0, candidates, target, mutableListOf<Int>(), result)
        return result
    }

    private fun search(
        index: Int,
        candidates: IntArray,
        target: Int,
        currentList: MutableList<Int>,
        result: MutableList<MutableList<Int>>
    ) {

        if (target == 0) {
            result.add(ArrayList(currentList))
            return
        }

        if (target < 0 || index >= candidates.size) {
            return
        }

        for (i in index until candidates.size) {
            currentList.add(candidates[i])
            search(i, candidates, target - candidates[i], currentList, result)
            currentList.removeAt(currentList.size - 1)
        }
    }
}
