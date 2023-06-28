package graphs

import java.util.*
import kotlin.collections.ArrayDeque


class WordLadder {

    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        if (!wordList.contains(endWord)) {
            return 0
        }

        val adjacencyMap = mutableMapOf<String, MutableList<String>>()
        val mutableWordList = wordList.toMutableList()

        mutableWordList.add(beginWord)
        for (word in mutableWordList) {
            for (j in word.indices) {
                val pattern = word.substring(0, j) + "*" + word.substring(j + 1)
                adjacencyMap.getOrPut(pattern) { mutableListOf() }.add(word)
            }
        }

        val visit = mutableSetOf(beginWord)
        val queue = ArrayDeque<String>()
        queue.add(beginWord)
        var res = 1

        while (queue.isNotEmpty()) {
            for (i in 0 until queue.size) {
                val word = queue.removeFirst()
                if (word == endWord) {
                    return res
                }

                for (j in word.indices) {
                    val pattern = word.substring(0, j) + "*" + word.substring(j + 1)

                    adjacencyMap[pattern]?.let { adjacents ->
                        for (adj in adjacents) {
                            if (adj !in visit) {
                                visit.add(adj)
                                queue.add(adj)
                            }
                        }
                    }
                }
            }

            res++
        }

        return 0
    }

}
