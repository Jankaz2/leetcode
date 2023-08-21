package dp_onedimensional

class SolvingQuestionsWithBrainpower {
    fun mostPoints(questions: Array<IntArray>): Long {
        val dp = LongArray(questions.size)

        for (i in questions.size - 1 downTo 0) {
            val (points, brainpower) = questions[i]
            val jump = i + brainpower + 1

            dp[i] = maxOf(
                if (jump in dp.indices) dp[jump] + points else points + 0L, // include
                if (i + 1 in dp.indices) dp[i + 1] else 0L         // skip
            )
        }

        return dp.first()
    }
}

fun main() {
    val solution = SolvingQuestionsWithBrainpower()
    println(
        solution.mostPoints(
            arrayOf(
                intArrayOf(1, 1),
                intArrayOf(2, 2),
                intArrayOf(3, 3),
                intArrayOf(4, 4),
                intArrayOf(5, 5)
            )
        )
    )
}
