package `1ddp`

class PartitionEqualSubsetSum {
    fun canPartition(nums: IntArray): Boolean {
        val sum = nums.sum()
        if (sum % 2 != 0) return false

        val dp = mutableSetOf(0)
        val target = sum / 2

        for (num in nums) {
            val tempDp = mutableSetOf<Int>()
            for (value in dp) {
                if (value + num == target) return true
                if (value + num < target) {
                    tempDp.add(value)
                }
            }

            dp.addAll(tempDp)
        }

        return false
    }
}

fun main() {
    val solution = PartitionEqualSubsetSum()
    solution.canPartition(intArrayOf(1, 5, 11, 5, 4))
}
