package graphs

class CourseScheduleIV {
    fun checkIfPrerequisite(numCourses: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): List<Boolean> {
        val answer = mutableListOf<Boolean>()
        val adjacencyMap = mutableMapOf<Int, MutableList<Int>>()
        prerequisites.forEach { (src, dst) ->
            adjacencyMap.getOrPut(dst) { mutableListOf() }.add(src)
        }

        val preq = mutableMapOf<Int, HashSet<Int>>()
        fun dfs(startCourse: Int, currentCourse: Int) {
            preq[startCourse]?.let { if (currentCourse in it) return }

            if (currentCourse != startCourse) {
                preq.getOrPut(startCourse) { hashSetOf() }.add(currentCourse)
            }

            for (nei in adjacencyMap[currentCourse] ?: mutableListOf()) {
                dfs(startCourse, nei)
            }
        }

        for (course in 0 until numCourses) {
            dfs(course, course)
        }

        queries.forEach { (src, dst) ->
            answer.add(preq[dst]?.let { src in it } ?: false)
        }

        return answer
    }
}
