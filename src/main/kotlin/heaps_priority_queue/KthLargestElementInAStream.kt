package heaps_priority_queue

import java.util.PriorityQueue

class KthLargestElementInAStream(val k: Int, val nums: IntArray) {

    private val heap = PriorityQueue<Int>(k)

    init {
        nums.forEach { add(it) }
    }

    fun add(`val`: Int): Int {
        heap.offer(`val`)
        if (heap.size > k) heap.poll()
        return heap.peek()
    }

}
