package linkedlist

class Node(
    val key: Int,
    var value: Int,
    var previous: Node? = null,
    var next: Node? = null,
)

class LRUCache(private val capacity: Int) {
    private val left = Node(0,0)
    private val right = Node(0,0)
    private val map = HashMap<Int, Node>()

    init {
        left.next = right
        right.previous = left
    }

    fun get(key: Int): Int {
        if (key !in map) return -1
        val nodeToBeReturned = map.getValue(key)
        removeNode(nodeToBeReturned)
        insertAtEnd(nodeToBeReturned)
        return nodeToBeReturned.value
    }

    fun put(key: Int, value: Int) {
        if (key in map) {
            val nodeToBeMoved = map.getValue(key).apply { this.value = value }
            removeNode(nodeToBeMoved)
            insertAtEnd(nodeToBeMoved)
            return
        }
        if (map.size == capacity) {
            val nodeToRemove = left.next!!
            removeNode(nodeToRemove)
            map.remove(nodeToRemove.key)
        }
        val newNode = Node(key, value)
        insertAtEnd(newNode)
        map[key] = newNode
    }

    private fun insertAtEnd(node: Node) {
        node.apply {
            previous = right.previous
            next = right
        }

        right.previous!!.next = node
        right.previous = node
    }

    private fun removeNode(node: Node) {
        node.previous?.next = node.next
        node.next?.previous = node.previous
    }

}

