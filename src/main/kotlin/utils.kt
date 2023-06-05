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
