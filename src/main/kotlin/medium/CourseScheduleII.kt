package medium

class CourseScheduleII {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val prereq = mutableMapOf<Int, MutableList<Int>>()
        val result = mutableListOf<Int>()
        val cycle = mutableSetOf<Int>()
        val visited = mutableSetOf<Int>()

        for (crs in 0 until numCourses) {
            prereq[crs] = mutableListOf()
        }

        for ((crs, pre) in prerequisites) {
            prereq[crs]!!.add(pre)
        }

        fun dfs(crs: Int): Boolean {
            if (cycle.contains(crs)) return false
            if (visited.contains(crs)) return true

            cycle.add(crs)
            for (p in prereq[crs]!!) {
                if (!dfs(p)) {
                    return false
                }
            }
            cycle.remove(crs)
            visited.add(crs)
            result.add(crs)

            return true
        }

        for (crs in 0 until numCourses) {
            if (!dfs(crs)) return intArrayOf()
        }

        return result.toIntArray()
    }
}

fun main() {
    val solution = CourseScheduleII()
    val prerequisites = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(2, 0),
        intArrayOf(3, 1),
        intArrayOf(3, 2),
    )

    solution.findOrder(4, prerequisites)
}
