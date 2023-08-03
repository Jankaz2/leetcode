package `1ddp`

class UncrossedLines {

    fun maxUncrossedLines(nums1: IntArray, nums2: IntArray): Int {
        val cache = Array(nums1.size + 1) { IntArray(nums2.size + 1) }

        for (i in nums1.indices) {
            for (j in nums2.indices) {
                if (nums1[i] == nums2[j]) {
                    cache[i + 1][j + 1] = 1 + cache[i][j] // i + 1 and j + 1 because we initialized array with size + 1 to resolve the edge case
                } else {
                    cache[i + 1][j + 1] = maxOf(
                        cache[i][j + 1],
                        cache[i + 1][j]
                    )
                }
            }
        }

        return cache[nums1.size + 1][nums2.size + 1]
    }

    fun maxUncrossedLinesRecursion(nums1: IntArray, nums2: IntArray): Int {
        val cache = mutableMapOf<Pair<Int, Int>, Int>()

        fun dfs(i: Int, j: Int): Int {
            if (i !in nums1.indices || j !in nums2.indices) return 0

            if (Pair(i, j) in cache) {
                return cache[Pair(i, j)]!!
            }

            if (nums1[i] == nums2[j]) {
                return 1 + dfs(i + 1, j + 1)
            } else {
                return maxOf(
                    dfs(i, j + 1),
                    dfs(i + 1, j)
                )
            }

            return cache[Pair(i, j)]!!
        }

        return dfs(0, 0)
    }
}
