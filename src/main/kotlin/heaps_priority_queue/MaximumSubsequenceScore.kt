package heaps_priority_queue

import java.util.*

class MaximumSubsequenceScore {
    fun maxScore(nums1: IntArray, nums2: IntArray, k: Int): Long {
        val combined = nums1.zip(nums2).sortedWith(compareBy { -it.second }) // descending sorting
        val minHeap = PriorityQueue<Int>()

        var sum = 0L
        var res = 0L
        for ((n1, n2) in combined) {
            sum += n1
            minHeap.offer(n1)

            if (minHeap.size > k)
                sum -= minHeap.poll()
            if (minHeap.size == k)
                res = maxOf(res, sum * n2)
        }

        return res
    }
}

fun main() {
    val solution = MaximumSubsequenceScore()
    val nums1 = intArrayOf(1, 3, 3, 2)
    val nums2 = intArrayOf(2, 1, 3, 4)
    solution.maxScore(nums1, nums2, 3)
}
