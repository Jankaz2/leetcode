package heaps_priority_queue

import java.util.*
import kotlin.collections.ArrayDeque


class TaskScheduler {

    fun leastInterval(tasks: CharArray, n: Int): Int {
        if (n == 0) return tasks.size
        val taskToCount = mutableMapOf<Char, Int>()

        tasks.forEach {
            taskToCount[it] = taskToCount.getOrDefault(it, 0) + 1
        }

        val pq = PriorityQueue<Int> { a, b -> Integer.compare(b, a) }
        for (count in taskToCount.values) {
            pq.offer(count)
        }

        var currTime = 0
        val q = ArrayDeque<Pair<Int, Int>>()

        while (pq.isNotEmpty() || q.isNotEmpty()) {
            if (pq.isNotEmpty()) {
                val removed = pq.poll() - 1
                if (removed != 0) {
                    q.add(Pair(removed, currTime + n))
                }
            }

            if (q.isNotEmpty() && q.first().second == currTime) {
                pq.offer(q.removeFirst().first)
            }

            currTime++
        }

        return currTime
    }
}

fun main() {
    val tasks = charArrayOf('A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G')
    val solution = TaskScheduler()
    solution.leastInterval(tasks, 2)
}
