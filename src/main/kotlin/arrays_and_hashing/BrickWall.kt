package arrays_and_hashing

class BrickWall {
    fun leastBricks(wall: List<List<Int>>): Int {
        val countGap = mutableMapOf<Int, Int>()

        for (row in wall) {
            var position = 0
            for (col in row.dropLast(1)) {
                position += col
                countGap[position] = 1 + countGap.getOrDefault(position, 0)
            }
        }

        return wall.size - (countGap.values.maxOrNull() ?: 0)
    }
}
