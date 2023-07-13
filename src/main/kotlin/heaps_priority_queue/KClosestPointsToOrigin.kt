package heaps_priority_queue

import java.util.*
import kotlin.math.sqrt

class KClosestPointsToOrigin {
    private fun calculateDistance(x: Int, y: Int): Double {
        return sqrt(((x * x) + (y * y)).toDouble())
    }

    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val pq = PriorityQueue<Pair<IntArray, Double>>(k) { x, y -> y.second.compareTo(x.second) }

        points.forEach { (x, y) ->
            val distance = calculateDistance(x, y)
            pq.offer(Pair(intArrayOf(x, y), distance))

            if (pq.size > k) pq.poll()
        }

        return pq.map { it.first }.toTypedArray()
    }
}
