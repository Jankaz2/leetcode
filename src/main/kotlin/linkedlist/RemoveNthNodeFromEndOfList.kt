package linkedlist

import ListNode

class RemoveNthNodeFromEndOfList {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy: ListNode? = ListNode(-1)
        dummy?.next = head
        var left = dummy
        var right: ListNode? = head
        var i = 0
        while (i < n) {
            right = right?.next
            i++
        }

        while (right != null) {
            right = right.next
            left = left?.next
        }

        val toDelete = left?.next
        left?.next = toDelete?.next
        toDelete?.next = null

        return dummy?.next
    }
}

fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next!!.next = ListNode(3)
    head.next!!.next!!.next = ListNode(4)
    head.next!!.next!!.next!!.next = ListNode(5)
    head.next!!.next!!.next!!.next!!.next = ListNode(6)
    head.next!!.next!!.next!!.next!!.next!!.next = ListNode(7)
    head.next!!.next!!.next!!.next!!.next!!.next!!.next = ListNode(8)

    val solution = RemoveNthNodeFromEndOfList()
    solution.removeNthFromEnd(head, 3)
}
