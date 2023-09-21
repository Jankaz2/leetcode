package arrays_and_hashing


class NumberOfPairsOfINterchangeableRectangles {
    fun interchangeableRectangles(rectangles: Array<IntArray>): Long {
        var counter: Long = 0
        var ratio: Double
        val freqByFraction: MutableMap<Double, Int> = HashMap()
        for ((w, h) in rectangles) {
            ratio = w / h.toDouble()
            counter += freqByFraction.getOrDefault(ratio, 0).toLong()
            freqByFraction[ratio] = freqByFraction.getOrDefault(ratio, 0) + 1
        }
        return counter
    }
}

fun main() {
    val solution = NumberOfPairsOfINterchangeableRectangles()
    solution.interchangeableRectangles(arrayOf(intArrayOf(4, 5), intArrayOf(7, 8)))
}
