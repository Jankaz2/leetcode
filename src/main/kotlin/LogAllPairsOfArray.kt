class LogAllPairsOfArray {
    fun logAllPairs(array: IntArray) {
        for (i in array) {
            for (j in array) {
                println("$i $j")
            }
        }
    }
}

fun main() {
    val solution = LogAllPairsOfArray()
    solution.logAllPairs(intArrayOf(1, 2, 3, 4, 5))
}
