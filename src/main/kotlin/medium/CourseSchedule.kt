package medium

class CourseSchedule {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        if (prerequisites.isEmpty()) return true

        val visited = mutableSetOf<Int>()
        val adjacencyMap = mutableMapOf<Int, MutableList<Int>>()

        for (i in 0 until numCourses) {
            adjacencyMap[i] = mutableListOf()
        }

        for ((crs, pre) in prerequisites) {
            adjacencyMap[crs]!!.add(pre)
        }

        fun dfs(crs: Int): Boolean {
            if (visited.contains(crs)) return false
            if (adjacencyMap[crs]!!.isEmpty()) return true

            visited.add(crs)
            for (pre in adjacencyMap[crs]!!) {
                if (!dfs(pre)) return false
            }

            visited.remove(crs)
            adjacencyMap[crs] = mutableListOf()
            return true
        }

        for (course in 0 until numCourses) {
            if (!dfs(course)) return false
        }

        return true
    }
}
