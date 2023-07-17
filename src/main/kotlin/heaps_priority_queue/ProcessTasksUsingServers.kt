package heaps_priority_queue

import java.util.*


class ProcessTasksUsingServers {

    data class Server(val index: Int, val weight: Int)
    data class Assignment(var freeTime: Int, var server: Server)

    fun assignTasks(servers: IntArray, tasks: IntArray): IntArray {
        val ans = mutableListOf<Int>()
        val sortedServers = PriorityQueue<Server> { s1, s2 ->
            if (s1.weight == s2.weight) s1.index - s2.index
            else s1.weight - s2.weight
        }

        val tasksList = tasks.toMutableList()
        val assignments = PriorityQueue<Assignment> { a1, a2 -> a1.freeTime - a2.freeTime}

        var time = 0
        var loopIndex = 0

        for (i in servers.indices) sortedServers.add(Server(i, servers[i]))

        while (loopIndex < tasks.size) {
            while (assignments.isNotEmpty() && assignments.peek().freeTime <= time) {
                sortedServers.offer(assignments.poll().server)
            }

            while (sortedServers.isNotEmpty() && loopIndex <= time && loopIndex < tasks.size) {
                if (sortedServers.isEmpty() || tasksList.isEmpty()) break

                val server = sortedServers.poll()
                val task = tasksList[0]
                tasksList.removeAt(0)

                ans.add(server.index)
                assignments.offer(Assignment(time + task, server))
                loopIndex++
            }

            if (!sortedServers.isEmpty()) time++ else time = assignments.peek().freeTime
        }

        return ans.toIntArray()
    }
}

fun main() {
    val solution = ProcessTasksUsingServers()
    val res = solution.assignTasks(
        intArrayOf(5, 1, 4, 3, 2),
        intArrayOf(2, 1, 2, 4, 5, 2, 1)
    )

    res.forEach { print("$it ") }
}
