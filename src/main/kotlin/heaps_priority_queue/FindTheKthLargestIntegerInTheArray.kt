package heaps_priority_queue

import java.util.*

class FindTheKthLargestIntegerInTheArray {
    fun kthLargestNumber(nums: Array<String>, k: Int): String {
        val maxHeap = PriorityQueue<String> { x, y -> y.toBigInteger().compareTo(x.toBigInteger()) }
        nums.forEach {
            maxHeap.offer(it)
        }

        var kth = k
        while(kth > 1) {
            maxHeap.poll()
            kth--
        }

        return maxHeap.poll().toString()
    }

}

fun main() {
    val solution = FindTheKthLargestIntegerInTheArray()
    solution.kthLargestNumber(
        arrayOf("2", "21", "12", "1"),
        3
    )
}
