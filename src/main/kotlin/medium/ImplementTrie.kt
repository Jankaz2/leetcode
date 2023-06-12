package medium

import TrieNode

class ImplementTrie

class Trie {

    var root = TrieNode()

    fun insert(str: String) {
        var current = root

        for (c in str) {
            val child = current.children.getOrPut(c) { TrieNode() }
            current = child
        }

        current.endOfWord = true
    }

    fun search(str: String): Boolean {
        var current = root

        for (c in str) {
            if (!current.children.containsKey(c)) {
                return false
            }
            current = current.children[c]!!
        }

        return current.endOfWord
    }

    fun startsWith(str: String): Boolean {
        var current = root
        for (c in str) {
            if (!current.children.containsKey(c)) {
                return false
            }
            current = current.children[c]!!
        }
        return true
    }

}
