package backtracking

class FindUniqueBinaryString {
    fun findDifferentBinaryString(nums: Array<String>): String {
        val hs = nums.toSet()
        val n = nums.size
        val temp = CharArray(n) { '0' }

        fun backtrack(i: Int): Boolean {
            if (i == n) {
                return temp.joinToString("") !in hs
            }
            
            return backtrack(i + 1) || run {
                temp[i] = '1'
                backtrack(i + 1)
            }
        }

        return if (backtrack(0)) temp.joinToString("") else ""
    }
}
