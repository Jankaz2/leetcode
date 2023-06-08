package medium

data class TimeStampValue(val timestamp: Int, val str: String)

class TimeBasedKeyValueStore {

    private val store = HashMap<String, MutableList<TimeStampValue>>()

    fun set(key: String, value: String, timestamp: Int) {
        store.getOrPut(key, ::mutableListOf).add(TimeStampValue(timestamp, value))
    }

    fun get(key: String, timestamp: Int): String {
        if (!store.containsKey(key)) { return "" }
        val list = store.getValue(key)
        return if (list.isEmpty()) "" else search(list, timestamp)
    }

    private fun search(timestampValueList: List<TimeStampValue>, timestamp: Int): String {
        if (timestampValueList.first().timestamp > timestamp) { return "" }
        if (timestampValueList.last().timestamp < timestamp) return timestampValueList.last().str

        var l = 0
        var r = timestampValueList.lastIndex
        var result = ""
        while (l <= r) {
            val mid = l + (r - l) / 2
            val ts = timestampValueList[mid].timestamp
            if (ts == timestamp) {
                return timestampValueList[mid].str
            } else if (ts > timestamp) {
                r = mid - 1
            } else {
                result = timestampValueList[mid].str
                l = mid + 1
            }
        }


        return result
    }
}

fun main() {
    val timeMap = TimeBasedKeyValueStore()
    timeMap.set("love", "high", 10)
    timeMap.set("love", "low", 20)
    val firstval = timeMap.get("love", 5)
    val secondVal = timeMap.get("love", 10)
    val thirdVal = timeMap.get("love", 15)
    val fourthVal = timeMap.get("love", 20)
    val fifthhVal = timeMap.get("love", 25)
}
