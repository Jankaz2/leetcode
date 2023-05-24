package easy

import ListNode

class MiddleOfTheLinkedList {
    fun middleNode(head: ListNode?): ListNode? {
        var slow = head
        var fast = head
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        return slow
    }
}

fun main() {
    val solution = MiddleOfTheLinkedList()
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next!!.next = ListNode(3)
    head.next!!.next!!.next = ListNode(4)
    head.next!!.next!!.next!!.next = ListNode(5)
    //println(solution.middleNode(henad)?.`val`)
    head.next!!.next!!.next!!.next!!.next = ListNode(6)
    println(solution.middleNode(head)?.`val`)
}
