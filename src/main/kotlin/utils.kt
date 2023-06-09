class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun printList(head: ListNode?) {
    var current = head
    while (current != null) {
        print("${current.`val`} -> ")
        current = current.next
    }
    println()
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class TrieNode {
    var children = mutableMapOf<Char, TrieNode>()
    var endOfWord = false
}

class Node(var `val`: Int) {
    var neighbors = ArrayList<Node?>()
}

fun printTreeNodes(root: TreeNode?) {
    if (root == null) return

    val queue = ArrayDeque<TreeNode>()
    queue.add(root)

    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        print("${node.`val`} ")

        node.left?.let { queue.add(it) }
        node.right?.let { queue.add(it) }
    }
    println()
}

fun IntRange.toIntArray(): IntArray {
    if (last < first)
        return IntArray(0)

    val result = IntArray(last - first + 1)
    var index = 0
    for (element in this)
        result[index++] = element
    return result
}
