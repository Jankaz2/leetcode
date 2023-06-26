package tries

import TrieNode

class WordDictionary {
    val root = TrieNode()

    fun addWord(word: String) {
        var current = root
        for (c in word) {
            val child = current.children.getOrPut(c) { TrieNode() }
            current = child
        }

        current.endOfWord = true
    }

    fun search(word: String): Boolean {

        fun dfs(j: Int, root: TrieNode): Boolean {
            var current = root

            for (i in j until word.length) {
                when (val c = word[i]) {
                    '.' -> {
                        for (child in current.children.values) {
                            return dfs(i + 1, child)
                        }
                    }

                    else -> {
                        if (!current.children.containsKey(c)) {
                            return false
                        }
                        current = current.children[c]!!
                    }
                }
            }

            return current.endOfWord
        }

        return dfs(0, root)
    }

    fun searchIterative(word: String): Boolean {
        var candidates = listOf(root)
        for (c in word) {
            candidates = when (c) {
                '.' -> candidates.flatMap { it.children.values }
                else -> candidates.mapNotNull { it.children[c] }
            }
            if (candidates.isEmpty()) return false
        }
        return candidates.any { it.endOfWord }
    }

}

fun main() {
    val wordDictionary = WordDictionary()
    wordDictionary.addWord("bad")
    wordDictionary.addWord("bcd")
    wordDictionary.addWord("bkg")
    wordDictionary.addWord("dad")
    wordDictionary.addWord("mad")
    println(wordDictionary.search("b..")) // return True
    println(wordDictionary.searchIterative("bad")) // return True
    println(wordDictionary.searchIterative("pad")) // return False
    println(wordDictionary.searchIterative(".ad")) // return True
}
