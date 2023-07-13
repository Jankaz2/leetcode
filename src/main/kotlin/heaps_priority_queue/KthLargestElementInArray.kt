package heaps_priority_queue

import java.util.*

class KthLargestElementInArray {

    // Priority Queue solution
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val pq = PriorityQueue<Int>(k)
        nums.forEach {
            pq.offer(it)
            if (pq.size > k) pq.poll()
        }

        return pq.peek()
    }

    // QuickSelect solution
    fun findKthLargestQuickSelect(nums: IntArray, k: Int): Int {
        val kIndex = nums.size - k

        fun quickSelect(left: Int, right: Int): Int {
            val pivot = nums[right]
            var pointer = left

            for (num in left until right) {
                if (nums[num] <= pivot) {
                    val temp = nums[num]
                    nums[num] = nums[pointer]
                    nums[pointer] = temp

                    pointer++
                }
            }

            val temp = nums[pointer]
            nums[pointer] = nums[right]
            nums[right] = temp

            return when {
                pointer > kIndex -> quickSelect(left, pointer - 1)
                pointer < kIndex ->quickSelect(pointer + 1, right)
                else -> nums[pointer]
            }
        }

        return quickSelect(0, nums.size - 1)
    }
}
