package medium

import ListNode

class ReorderList {
    fun reorderList(head: ListNode?) {
        var slow = head
        var fast = head
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next!!.next
        }

        var firstHalfList = head
        var secondHalfList = reverseList(slow?.next)
        var secondHalfListNext = secondHalfList?.next
        slow?.next = null

        while (secondHalfList != null) {
            secondHalfList.next = firstHalfList?.next
            firstHalfList?.next = secondHalfList

            firstHalfList = secondHalfList.next
            secondHalfList = secondHalfListNext
            secondHalfListNext = secondHalfList?.next
        }
    }

    fun reverseList(head: ListNode?): ListNode? {
        var previous: ListNode? = null
        var current = head

        while (current != null) {
            val next = current.next
            current.next = previous
            previous = current
            current = next
        }

        return previous
    }
}
