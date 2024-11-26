package linkedlist

import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

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

class TTLCache<K, V>(private val cleanupIntervalInSeconds: Long) {
    private val cacheMap = ConcurrentHashMap<K, CacheEntry<V>>()
    private val cleaner: ScheduledExecutorService = Executors.newSingleThreadScheduledExecutor()

    private data class CacheEntry<V>(val value: V, val expiryTime: Long) {
        fun isExpired(): Boolean = System.currentTimeMillis() > expiryTime
    }

    init {
        startCleanupTask()
    }

    private fun startCleanupTask() {
        cleaner.scheduleAtFixedRate({
            val currentTime = System.currentTimeMillis()
            for ((key, entry) in cacheMap) {
                if (entry.isExpired()) {
                    cacheMap.remove(key)
                }
            }
        }, cleanupIntervalInSeconds, cleanupIntervalInSeconds, TimeUnit.SECONDS)
    }

    fun put(key: K, value: V, ttlInMillis: Long) {
        cacheMap[key] = CacheEntry(value, System.currentTimeMillis() + ttlInMillis)
    }

    fun get(key: K): V? {
        val entry = cacheMap[key] ?: return null
        return if (entry.isExpired()) {
            cacheMap.remove(key)
            null
        } else {
            entry.value
        }
    }

    fun remove(key: K) {
        cacheMap.remove(key)
    }

    fun shutdown() {
        cleaner.shutdown()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val cache = TTLCache<String, String>(5) // Cleanup every 5 seconds
            cache.put("key1", "value1", 3000) // TTL 3 seconds
            println("key1: ${cache.get("key1")}") // Should print "value1"
            Thread.sleep(4000)
            println("key1 after 4 seconds: ${cache.get("key1")}") // Should print "null"
            cache.shutdown()
        }
    }
}
