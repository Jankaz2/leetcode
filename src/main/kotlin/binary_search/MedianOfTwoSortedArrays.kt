package binary_search

class MedianOfTwoSortedArrays {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val A: Int = nums1.size
        val B: Int = nums2.size

        if (A > B) {
            return findMedianSortedArrays(nums2, nums1)
        }

        val total = A + B
        val half = (total + 1) / 2

        var left = 0
        var right = A

        var result = 0.0

        while (left <= right) {
            val i = left + (right - left) / 2
            val j = half - i

            // get the four points around possible median
            val Aleft = if (i > 0) nums1[i - 1] else Int.MIN_VALUE
            val Aright = if (i < A) nums1[i] else Int.MAX_VALUE
            val Bleft = if (j > 0) nums2[j - 1] else Int.MIN_VALUE
            val Bright = if (j < B) nums2[j] else Int.MAX_VALUE

            // partition is correct
            if (Aleft <= Bright && Bleft <= Aright) {
                // even
                result = if (total % 2 == 0) {
                    (Aleft.coerceAtLeast(Bleft) + Aright.coerceAtMost(Bright)) / 2.0
                // odd
                } else {
                    Aleft.coerceAtLeast(Bleft).toDouble()
                }
                break
            } else if (Aleft > Bright) {
                right = i - 1
            } else {
                left = i + 1
            }
        }

        return result
    }
}

fun main() {
    val solution = MedianOfTwoSortedArrays()
//    println(
//        solution.findMedianSortedArrays(
//            intArrayOf(1, 2, 3, 5, 7, 10, 11, 12, 20, 21),
//            intArrayOf(2, 3, 8, 9, 14, 16, 19, 20, 22, 28, 30)
//        )
//    )
    println(solution.findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2)))
}
