package easy

import ListNode
import printList

class RemoveDuplicatesFromSortedList {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        var previous = head
        var current = head?.next
        while (current != null) {
            val next = current.next
            if (current.`val` == previous?.`val`) {
                current = next
                previous.next = current
            } else {
                previous = current
                current = current.next
            }
        }

        return head
    }

}

fun main() {
    val solution = RemoveDuplicatesFromSortedList()
    val head = ListNode(1)
    head.next = ListNode(1)
    head.next!!.next = ListNode(2)
    head.next!!.next!!.next = ListNode(3)
    head.next!!.next!!.next!!.next = ListNode(3)
    printList(head)
    printList(solution.deleteDuplicates(head))
}
