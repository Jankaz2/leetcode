package graphs

class OpenTheLock {
    fun openLock(deadends: Array<String>, target: String): Int {
        if (deadends.contains("0000")) return -1

        fun getChildren(lock: String): List<String> {
            val result = mutableListOf<String>()
            for (i in 0 until 4) {
                var digit = ((Character.getNumericValue(lock[i]) + 1) % 10).toString()
                result.add(lock.substring(0, i) + digit + lock.substring(i + 1))
                digit = ((Character.getNumericValue(lock[i]) - 1) + 10 % 10).toString()
                result.add(lock.substring(0, i) + digit + lock.substring(i + 1))
            }

            return result
        }

        val visited = mutableSetOf(*deadends)
        val q = ArrayDeque<Pair<String, Int>>()
        q.add(Pair("0000", 0))

        while (q.isNotEmpty()) {
            val (lock, turns) = q.removeFirst()
            if (lock == target) {
                return turns
            }

            for (child in getChildren(lock)) {
                if (child !in visited) {
                    visited.add(child)
                    q.add(Pair(child, turns + 1))
                }
            }
        }

        return -1
    }
}
