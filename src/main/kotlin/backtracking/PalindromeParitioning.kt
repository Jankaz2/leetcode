package backtracking


class PalindromeParitioning {

    fun partition(s: String): List<List<String>> {
        val res = mutableListOf<MutableList<String>>()
        val partition = mutableListOf<String>()

        fun dfs(index: Int) {
            if (index >= s.length) {
                res.add(partition.toMutableList())
                return
            }

            for (i in index until s.length) {
                if (isPali(s, index, i)) {
                    partition.add(s.substring(index, i + 1))
                    dfs(i + 1)
                    partition.removeAt(partition.lastIndex)
                }
            }
        }

        dfs(0)
        return res
    }

    private fun isPali(s: String, l: Int, r: Int): Boolean {
        var left = l
        var right = r
        while (left < right) {
            if (s[left] != s[right]) return false
            left++; right--
        }
        return true
    }
}

fun main() {
    val solution = PalindromeParitioning()
    solution.partition("aab")
}
