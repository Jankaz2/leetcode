package dp_onedimensional

class Tribonacci {
    fun tribonacci(n: Int): Int {
        if (n == 0) return n

        var first = 0
        var second = 1
        var third = 1

        for (i in 3..n) {
            val tempResult = first + second + third
            val tempSecond = second
            second = third
            first = tempSecond
            third = tempResult
        }

        return third
    }
}
