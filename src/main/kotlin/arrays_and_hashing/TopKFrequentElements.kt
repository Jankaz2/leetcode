package arrays_and_hashing

class TopKFrequentElements {

    // O(nlog(n))
    fun topKFrequent2(nums: IntArray, k: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for (n in nums) {
            if (map.containsKey(n)) {
                map[n] = map[n]!! + 1
            } else {
                map[n] = 1
            }
        }

        return map.entries.sortedByDescending { it.value }.map { it.key }.take(k).toIntArray()
    }

    // O(n)
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val result = mutableListOf<Int>()
        val bucket = MutableList<MutableList<Int>>(nums.size + 1) { mutableListOf() }
        val map = mutableMapOf<Int, Int>()
        for (n in nums) {
            map[n] = map.getOrDefault(n, 0) + 1
        }

        for ((key, value) in map) {
            bucket[value].add(key)
        }

        for (i in bucket.size - 1 downTo 0) {
            for (j in bucket[i]) {
                if (result.size == k) {
                    break;
                }

                result.add(j)
            }
            if (result.size == k) {
                break;
            }
        }

        return result.toIntArray()
    }
}

fun main() {
    val solution = TopKFrequentElements()
    solution.topKFrequent(intArrayOf(1, 1, 1, 2, 2, 2, 3), 2).forEach { print("$it ") }
    //solution.topKFrequent(intArrayOf(1), 1)
}
