package medium

import ListNode
import printList

class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var dummy = ListNode(-1)
        val res = dummy
        var list1 = l1
        var list2 = l2
        var memory = 0
        while (list1 != null || list2 != null) {
            val sum = (list1?.`val` ?: 0) + (list2?.`val` ?: 0) + memory
            memory = sum / 10
            dummy.next = ListNode(sum % 10)
            dummy = dummy.next!!
            list1 = list1?.next
            list2 = list2?.next
        }

        if (memory == 1) {
            dummy.next = ListNode(1)
        }

        return res.next
    }
}

fun main() {
    val solution = AddTwoNumbers()
    val head1 = ListNode(2)
    head1.next = ListNode(4)
    head1.next!!.next = ListNode(3)
//    head1.next!!.next!!.next = ListNode(9)
//    head1.next!!.next!!.next!!.next = ListNode(9)
//    head1.next!!.next!!.next!!.next!!.next = ListNode(9)
//    head1.next!!.next!!.next!!.next!!.next!!.next = ListNode(9)

    val head2 = ListNode(5)
    head2.next = ListNode(6)
    head2.next!!.next = ListNode(4)
    //head2.next!!.next!!.next = ListNode(9)

    printList(solution.addTwoNumbers(head1, head2))

    /*head1.next!!.next!!.next = ListNode(4)
    head1.next!!.next!!.next!!.next = ListNode(5)
    head1.next!!.next!!.next!!.next!!.next = ListNode(6)
    head1.next!!.next!!.next!!.next!!.next!!.next = ListNode(7)
    head1.next!!.next!!.next!!.next!!.next!!.next!!.next = ListNode(8)*/

}
