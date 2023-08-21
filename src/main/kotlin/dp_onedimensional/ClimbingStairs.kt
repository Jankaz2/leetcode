package dp_onedimensional

class ClimbingStairs {
    fun climbStairs(n: Int): Int {
        var one = 1
        var two = 1
        for (s in 0 until n - 1) {
            val temp = one
            one += two
            two = temp
        }

        return one
    }
}
