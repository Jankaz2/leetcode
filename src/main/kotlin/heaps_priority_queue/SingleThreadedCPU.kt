package heaps_priority_queue

import java.util.PriorityQueue

class SingleThreadedCPU {

    data class Task(val enqueueTime: Int, val processingTime: Int, val index: Int)

    fun getOrder(tasks: Array<IntArray>): IntArray {
        val result = mutableListOf<Int>()
        val sortedTasks = Array(tasks.size) { Task(0,0,0) }
        tasks.forEachIndexed { index, (enq, proc) -> sortedTasks[index] = Task(enq, proc, index) }
        sortedTasks.sortBy { it.enqueueTime }

        val availableTasks = PriorityQueue<Task> { t1, t2 ->
            if (t1.processingTime == t2.processingTime) t1.index - t2.index
            else t1.processingTime - t2.processingTime
        }

        var time = sortedTasks[0].enqueueTime
        var idx = 0

        while (availableTasks.isNotEmpty() || idx in sortedTasks.indices) {
            while (idx in sortedTasks.indices && time >= sortedTasks[idx].enqueueTime) {
                availableTasks.offer(
                    Task(sortedTasks[idx].enqueueTime, sortedTasks[idx].processingTime, sortedTasks[idx].index)
                )
                idx++
            }

            when {
                availableTasks.isNotEmpty() -> {
                    val task = availableTasks.poll()
                    time += task.processingTime
                    result.add(task.index)
                }
                else -> {
                    time = sortedTasks[idx].enqueueTime
                }
            }

        }

        return result.toIntArray()
    }
}

fun main() {
    val tasks = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(2, 4),
        intArrayOf(3, 2),
        intArrayOf(4, 1),
    )

    val solution = SingleThreadedCPU()
    val res = solution.getOrder(tasks)
    res.forEach { println(it) }
}
