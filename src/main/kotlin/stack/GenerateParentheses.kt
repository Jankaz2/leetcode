package stack


class GenerateParentheses {

    fun generateParenthesis(n: Int): List<String> {
        val res: MutableList<String> = ArrayList()
        recurse(res, 0, 0, "", n)
        return res
    }

    private fun recurse(res: MutableList<String>, left: Int, right: Int, s: String, n: Int) {
        println("recurse called for : $s left : $left right : $right")
        if (s.length == n * 2) {
            res.add(s)
            return
        }
        if (left < n) {
            recurse(res, left + 1, right, "$s(", n)
        }
        if (right < left) {
            recurse(res, left, right + 1, "$s)", n)
        }
    }
}

fun main() {
    val solution = GenerateParentheses()
    solution.generateParenthesis(3)
}
