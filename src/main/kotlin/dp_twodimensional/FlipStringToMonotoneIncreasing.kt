package dp_twodimensional

class FlipStringToMonotoneIncreasing {
    fun minFlipsMonoIncr2(s: String): Int {
        var res = 0
        var countOnes = 0
        for (c in s) {
            if (c == '1') {
                countOnes++
            } else {
                res = minOf(res + 1, countOnes)
            }
        }

        return res
    }

    fun minFlipsMonoIncr(s: String): Int {
        val cache = mutableMapOf<Pair<Int, Boolean>, Int>()

        fun dfs(i: Int, allZeroes: Boolean): Int {
            if (i >= s.length) return 0
            if (Pair(i, allZeroes) in cache) return cache[Pair(i, allZeroes)]!!

            if (allZeroes && s[i] == '0') {
                cache[Pair(i, allZeroes)] = minOf(
                    dfs(i + 1, allZeroes),
                    1 + dfs(i + 1, false)
                )
            } else if (allZeroes && s[i] == '1') {
                cache[Pair(i, allZeroes)] = minOf(
                    1 + dfs(i + 1, allZeroes),
                    dfs(i + 1, false)
                )
            } else if (!allZeroes && s[i] == '1') {
                cache[Pair(i, allZeroes)] = dfs(i + 1, allZeroes)
            } else {
                cache[Pair(i, allZeroes)] = 1 + dfs(i + 1, allZeroes)
            }

            return cache[Pair(i, allZeroes)]!!
        }

        return dfs(0, true)
    }
}

fun main() {
    val solution = FlipStringToMonotoneIncreasing()
    solution.minFlipsMonoIncr("00110")
}
