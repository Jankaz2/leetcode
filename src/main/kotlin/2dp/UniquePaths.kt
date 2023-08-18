package `2dp`

class UniquePaths {
    fun uniquePaths(m: Int, n: Int): Int {
        val memory = Array(m) { IntArray(n) { 1 } }

        for (i in 1 until m) {
            for (j in 1 until n) {
                memory[i][j] = memory[i][j - 1] + memory [i - 1][j]
            }
        }

        return memory[m - 1][n - 1]
    }
}
