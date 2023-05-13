package medium

class GroupAnagrams {

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val result = mutableMapOf<String, MutableList<String>>()

        for (str in strs) {
            val sorted = str.toCharArray().sorted()
            result[sorted.toString()]?.add(str) ?: result.put(sorted.toString(), mutableListOf(str))
        }

        return result.map { it.value.toList() }.toList()
    }
}

