package easy

import ListNode

class RemoveLinkedListElements {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        val dummy = ListNode(-1)
        dummy.next = head
        var previous = dummy
        var current = head
        while (current != null) {
            val next = current.next
            if (current.`val` == `val`) {
                previous.next = next
            } else {
                previous = current
            }
            current = next
        }

        return dummy.next
    }

}

fun main() {
    val solution = RemoveLinkedListElements()
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next!!.next = ListNode(6)
    head.next!!.next!!.next = ListNode(3)
    head.next!!.next!!.next!!.next = ListNode(4)
    head.next!!.next!!.next!!.next!!.next = ListNode(5)
    head.next!!.next!!.next!!.next!!.next!!.next = ListNode(6)
    solution.removeElements(head, 7)
}
