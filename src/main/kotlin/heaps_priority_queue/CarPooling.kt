package heaps_priority_queue

import java.util.*

class CarPooling {
    data class PickupPoint(val pickupPoint: Int, val passengers: Int)

    fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
        val pickupPoints = PriorityQueue<PickupPoint>(compareBy { it.pickupPoint })
        trips.forEach {
            pickupPoints.offer(PickupPoint(it[1], it[0]))
            pickupPoints.offer(PickupPoint(it[2], -it[0]))
        }

        var mutableCapacity = capacity
        var previous: PickupPoint?

        while (pickupPoints.isNotEmpty()) {
            do {
                val current = pickupPoints.poll()
                mutableCapacity -= current.passengers
                previous = current
            } while (
                pickupPoints.isNotEmpty()
                && pickupPoints.peek().pickupPoint == previous?.pickupPoint
            )

            if (mutableCapacity < 0) return false
        }

        return true
    }
}
