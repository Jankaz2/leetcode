package two_pointers

class ContainerWithMostWater {

    fun maxArea(height: IntArray): Int {
        var i = 0
        var j = height.size - 1
        var result = 0
        while (i < j) {
            when {
                height[i] <= height[j] -> {
                    val temp = height[i] * (j - i)
                    if (temp > result) result = temp
                    i++
                }
                height[i] >= height[j] -> {
                    val temp = height[j] * (j - i)
                    if (temp > result) result = temp
                    j--
                }
            }
        }

        return result
    }

}

fun main() {
    val solution = ContainerWithMostWater()
    println(solution.maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
    println(solution.maxArea(intArrayOf(1, 1)))
}
