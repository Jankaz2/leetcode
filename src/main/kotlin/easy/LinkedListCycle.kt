package easy

import ListNode

class LinkedListCycle {
    fun hasCycle(head: ListNode?): Boolean {
        var slow = head
        var fast = head
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
            if (fast == slow) return false
        }
        return true
    }
}

fun main() {
    val solution = LinkedListCycle()
    val head = ListNode(3)
    head.next = ListNode(2)
    head.next!!.next = ListNode(0)
    head.next!!.next!!.next = ListNode(-4)
}
