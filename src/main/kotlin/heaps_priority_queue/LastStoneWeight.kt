package heaps_priority_queue

import java.util.*

class LastStoneWeight {

    fun lastStoneWeight(stones: IntArray): Int {
        if (stones.size == 1) return stones[0]

        val pq = PriorityQueue<Int>(stones.size) { x, y -> Integer.compare(y, x) }
        stones.forEach { pq.offer(it) }

        while (pq.isNotEmpty()) {
            if (pq.size == 1) return pq.poll()
            val y = pq.poll()
            val x = pq.poll()

            if (x != y) {
                pq.offer(y - x)
            }
        }

        return 0
    }
}

fun main() {
    val solution = LastStoneWeight()
    val stones = intArrayOf(2, 7, 4, 1, 8, 1)
    solution.lastStoneWeight(stones)
}
