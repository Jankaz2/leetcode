package backtracking

class Combinations {
    fun combine(n: Int, k: Int): List<List<Int>> {
        if (n == 1) return listOf(listOf(n))
        val combinations = mutableListOf<MutableList<Int>>()

        fun dfs(num: Int, combination: MutableList<Int>) {
            if (combination.size == k) {
                combinations.add(ArrayList(combination))
                return
            }

            for (i in num..n) {
                combination.add(i)
                dfs(i + 1, combination)
                combination.removeAt(combination.lastIndex)
            }
        }

        dfs(1, mutableListOf())
        return combinations
    }
}

fun main() {
    val solution = Combinations()
    solution.combine(4, 2)
}
