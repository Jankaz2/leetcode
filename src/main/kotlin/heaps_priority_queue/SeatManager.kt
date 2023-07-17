package heaps_priority_queue

import java.util.*

class SeatManager(n: Int) {
    private val minHeap = PriorityQueue<Int>()

    init { (1..n + 1).forEach { minHeap.offer(it) } }

    fun reserve(): Int {
        return minHeap.poll()
    }

    fun unreserve(seatNumber: Int) {
        minHeap.offer(seatNumber)
    }
}
