package easy

class AddBinary {

    fun addBinary2(a: String, b: String): String? {
        val sb = StringBuilder()
        var carry = 0
        var i = a.length - 1
        var j = b.length - 1
        while (i >= 0 || j >= 0 || carry == 1) {
            if (i >= 0) carry += a[i--].code - '0'.code
            if (j >= 0) carry += b[j--].code - '0'.code
            sb.append(carry % 2)
            carry /= 2
        }
        return sb.reverse().toString()
    }

    fun addBinary(a: String, b: String): String {
        var memory = 0
        var bCopy = b
        var aCopy = a
        val result = StringBuilder()

        when {
            a.length > b.length -> {
                val zeroes = "0".repeat(a.length - b.length)
                bCopy = zeroes.plus(b)
            }

            b.length > a.length -> {
                val zeroes = "0".repeat(b.length - a.length)
                aCopy = zeroes.plus(a)
            }
        }


        for (i in aCopy.length - 1 downTo 0) {
            val sum = aCopy[i].toString().toInt() + bCopy[i].toString().toInt() + memory
            if (i != 0) {
                when (sum) {
                    3 -> {
                        result.insert(0, "1")
                        memory = 1
                    }
                    2 -> {
                        result.insert(0, "0")
                        memory = 1
                    }
                    1 -> {
                        result.insert(0, "1")
                        memory = 0
                    }
                    0 -> {
                        result.insert(0, "0")
                        memory = 0
                    }
                }
            } else {
                when (sum) {
                    3 -> result.insert(0, "11")
                    2 -> result.insert(0, "10")
                    1 -> result.insert(0, "1")
                    0 -> result.insert(0, "0")
                }
            }
        }

        return result.toString()
    }
}

fun main() {
    val solution = AddBinary()
    //println(solution.addBinary2("11", "1"))
    println(solution.addBinary2("1010", "1011"))
}
