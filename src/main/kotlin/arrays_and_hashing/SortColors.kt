package arrays_and_hashing

class SortColors {
    fun sortColors(nums: IntArray): Unit {
        var i = 0; var l = 0
        var r = nums.lastIndex
        fun swap(i: Int, j: Int) {
            val temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
        }

        while (i <= r) {
            if (nums[i] == 0) {
                swap(l, i)
                l++
            } else if (nums[i] == 2) {
                swap(i, r)
                r--
                i--
            }
            i++
        }
    }
}
