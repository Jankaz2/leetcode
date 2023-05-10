package easy

class ReverseAString {
    fun reverse(s: String): String {
        if (s.length < 2) return s

        val stringBuilder = StringBuilder()
        for (i in s.length - 1 downTo 0) {
            stringBuilder.append(s[i])
        }
        return stringBuilder.toString()
    }
}

fun main() {
    val solution = ReverseAString()
    println(solution.reverse("Hi my name is Andrei"))
}
