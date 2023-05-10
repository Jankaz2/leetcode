package easy

class LengthOfLastWord {
    fun lengthOfLastWord(s: String): Int {
        return s.trim().split(" ").last().length
    }
}

fun main() {
    val solution = LengthOfLastWord()
    println(solution.lengthOfLastWord("Hello World"))
    println(solution.lengthOfLastWord("  fly me   to   the moon  "))
    println(solution.lengthOfLastWord("luffy is still joyboy"))
}
