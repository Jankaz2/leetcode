package backtracking

class PartitionToKEqualSumSubsets {
    fun canPartitionKSubsets(nums: IntArray, k: Int): Boolean {
        val sum = nums.sum()
        if (sum % k != 0) return false
        val targetSum = sum / k
        val visited = mutableSetOf<Int>()
        nums.sortDescending()

        fun backtrack(idx: Int, howManySubsetsLeft: Int, subsetSum: Int): Boolean {
            if (howManySubsetsLeft == 0) return true
            if (subsetSum == targetSum) {
                return backtrack(0, howManySubsetsLeft - 1, 0)
            }

            for (j in idx until nums.size) {
                val currentSum = subsetSum + nums[j]
                if (j !in visited && currentSum <= targetSum) {
                    visited.add(j)
                    if (backtrack(j + 1, howManySubsetsLeft, currentSum)) {
                        return true
                    }
                    visited.remove(j)
                }
            }

            return false
        }

        return backtrack(0, k, 0)
    }
}
