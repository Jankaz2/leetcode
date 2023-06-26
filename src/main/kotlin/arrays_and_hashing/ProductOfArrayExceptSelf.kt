package arrays_and_hashing

class ProductOfArrayExceptSelf {
    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        var prefix = 1
        var postfix = 1

        for (i in nums.indices) {
            result[i] = prefix
            prefix *= nums[i]
        }

        for (i in nums.size - 1 downTo  0) {
            result[i] *= postfix
            postfix *= nums[i]
        }

        return result
    }
}

fun main() {
    val solution = ProductOfArrayExceptSelf()
    solution.productExceptSelf(intArrayOf(1, 2, 3, 4)).forEach {
        print("$it ")
    }
    println()
    solution.productExceptSelf(intArrayOf(-1, 1, 0, -3, 3)).forEach {
        print("$it ")
    }
}
