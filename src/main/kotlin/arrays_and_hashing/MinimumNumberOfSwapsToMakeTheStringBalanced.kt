package arrays_and_hashing

class MinimumNumberOfSwapsToMakeTheStringBalanced {
    fun minSwaps(s: String): Int {
        var extraClose = 0
        var max = 0

        for (c in s) {
            if (c == ']') extraClose++
            else extraClose--

            max = maxOf(max, extraClose)
        }

        return (max + 1) / 2
    }
}

fun main() {
    val solution = MinimumNumberOfSwapsToMakeTheStringBalanced()
    solution.minSwaps("]]][[[")
}
