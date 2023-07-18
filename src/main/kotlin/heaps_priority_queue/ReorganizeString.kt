package heaps_priority_queue

import java.util.PriorityQueue

class ReorganizeString {
    fun reorganizeString(s: String): String {
        val occurencyMap = mutableMapOf<Char, Int>()
        for (c in s) {
            if (c in occurencyMap) occurencyMap[c] = occurencyMap[c]!! + 1 else occurencyMap[c] = 1
        }

        val maxHeap = PriorityQueue<Pair<Char, Int>> { a, b -> b.second - a.second }
        occurencyMap.map { Pair(it.key, it.value) }.forEach { maxHeap.offer(it) }

        var prev: Pair<Char, Int>? = null
        val res = StringBuilder()

        while (maxHeap.isNotEmpty() || prev != null) {
            if (prev != null && maxHeap.isEmpty()) {
                return ""
            }

            val (char, cnt) = maxHeap.poll()
            res.append(char)
            val newCnt = cnt - 1

            if (prev != null) {
                maxHeap.add(Pair(prev.first, prev.second))
                prev = null
            }

            if (newCnt != 0) {
                prev = Pair(char, newCnt)
            }
        }

        return res.toString()
    }
}

fun main() {
    val solution = ReorganizeString()
    solution.reorganizeString("aaab")
}
