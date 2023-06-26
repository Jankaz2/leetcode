package two_pointers

class ThreeSum {

    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) return emptyList()
        if (nums.size == 3) if (nums.sum() == 0) return listOf(nums.toList()) else emptyList<Int>()
        nums.sort()
        val solutions = mutableListOf<List<Int>>()
        val size = nums.size
        for (i in 0 until size - 2) {
            var j = i + 1
            var k = size - 1
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] > 0) k--
                else if (nums[i] + nums[j] + nums[k] < 0) j++
                else {
                    solutions.add(listOf(nums[i], nums[j], nums[k]))
                    j++; k--
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++
                    }
                    while (k > j && nums[k] == nums[k + 1]) {
                        k--
                    }
                }
            }
        }
        return solutions
    }

}

fun main() {
    val solution = ThreeSum()
    solution.threeSum(intArrayOf(-2, 0, 1, 1, 2)).forEach { print(it) }
    println()
    solution.threeSum(intArrayOf(0, 1, 1)).forEach { print(it) }
    println()
    solution.threeSum(intArrayOf(0, 0, 0)).forEach { print(it) }
}
