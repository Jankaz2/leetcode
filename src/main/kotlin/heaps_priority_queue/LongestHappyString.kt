package heaps_priority_queue

import java.util.*

class LongestHappyString {
    private class Letter(var letter: Char, var count: Int)

    fun longestDiverseString(a: Int, b: Int, c: Int): String {
        val result = StringBuilder()

        val lettersPQ = PriorityQueue<Letter>(compareBy { -it.count }).apply {
            if (a > 0) add(Letter('a', a))
            if (b > 0) add(Letter('b', b))
            if (c > 0) add(Letter('c', c))
        }

        var currLetter = lettersPQ.poll()

        while (currLetter != null) {
            val appendCount = if (currLetter.count > 1) {
                val nextLetter = lettersPQ.peek()
                if (nextLetter != null && nextLetter.count > currLetter.count) {
                    1
                } else {
                    2
                }
            } else {
                1
            }

            repeat(appendCount) {
                result.append(currLetter.letter)
            }

            currLetter.count -= appendCount
            val nextLetter = lettersPQ.poll()

            if (currLetter.count > 0) {
                lettersPQ.add(currLetter)
            }

            currLetter = nextLetter
        }

        return result.toString()
    }
}

fun main() {
    val solution = LongestHappyString()
    solution.longestDiverseString(4, 3, 7)
}
